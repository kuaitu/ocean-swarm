package com.lmk.common;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.lmk.common.utils.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.yaml.snakeyaml.Yaml;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GeneratorUtils_Idea {
    public static String scanner(String tip) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 选择项目
     **/
    public static String chooseProject(String nowProjectPath) {
        List<String> excludeProjects = Arrays.asList("common-parent", "gateway", "registry",
                ".git", ".gitignore", "HELP.md", ".idea", "README.md");
        String parentFilePath[] = Arrays.stream(new File(nowProjectPath).list())
                .filter(projectName -> {
                    String name = projectName.substring(projectName.indexOf("-") + 1);
                    return !excludeProjects.contains(name);
                })
                .collect(Collectors.toList())
                .toArray(new String[0]);

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parentFilePath.length; i++) {
            System.out.println(i + "-" + parentFilePath[i] + "（" + parentFilePath[i] + "）");
        }
        System.out.println("请选择需生成代码的项目（直接回车默认0）：");

        String readString = scanner.nextLine();
        while (readString != null) {
            if (StringUtils.isEmpty(readString)) {
                return parentFilePath[0];
            } else {
                try {
                    Integer index = Integer.valueOf(readString);
                    if (index >= parentFilePath.length) {
                        throw new MybatisPlusException("请输入正确序号！");
                    }
                    return parentFilePath[index];
                } catch (Exception e) {
                    throw new MybatisPlusException("请输入正确序号！");
                }
            }
        }
        throw new MybatisPlusException("请输入正确序号！");
    }

    public static void main(String[] args) throws IOException {
        printDBTableList(getBizTableInfo(getDataSourceConfig()));
        // 接入终端名配置
        //String packageName = chooser();

        // 设置各个模块的路径
        ProjectPath projectPath = new ProjectPath();
        String nowProjectPath = System.getProperty("user.dir");
        String parentProjectPath = chooseProject(nowProjectPath);
        String packageName = parentProjectPath.substring(0, parentProjectPath.lastIndexOf("-"));
        String filePath[] = new File(nowProjectPath + "\\" +parentProjectPath).list();

        if (filePath.length != 0) {
            for (int i = 0; i < filePath.length; i++) {
                if (filePath[i].endsWith(EnumProject.API.getCode())) {
                    projectPath.setApiProjectPath(nowProjectPath + "\\" + parentProjectPath + "\\" + filePath[i]);
                    continue;
                }
                if (filePath[i].endsWith(EnumProject.APP.getCode())) {
                    projectPath.setAppProjectPath(nowProjectPath + "\\" + parentProjectPath + "\\" + filePath[i]);
                    continue;
                }
                if (filePath[i].endsWith(EnumProject.RPC.getCode())) {
                    projectPath.setClientProjectPath(nowProjectPath + "\\" + parentProjectPath + "\\" + filePath[i]);
                    continue;
                }
                if (filePath[i].endsWith(EnumProject.ENTITY.getCode())) {
                    projectPath.setModelProjectPath(nowProjectPath + "\\" + parentProjectPath + "\\" + filePath[i]);
                    continue;
                }
            }
        }
        generate(new String[] { "com", "lmk", packageName.split("-")[1] }, packageName, projectPath);
    }

    public static void generate(String[] packageInfo, String packageName, ProjectPath projectPath) throws IOException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projectPath.getAppProjectPath() + "/src/main/java");
        gc.setAuthor(System.getProperty("user.name"));
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());

        String tableName = scanner("表名");
        if (tableName.indexOf("_") == -1) {
            throw new MybatisPlusException("表名不符合标准，请使用[模块前缀_表名称]这种格式命名");
        }

        String moduleName = tableName.substring(0, tableName.indexOf("_"));

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(StringUtils.join(packageInfo, "."));
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        // 如果模板引擎是 freemarker
        List<FileOutConfig> focList = new ArrayList<>(); // 自定义输出配置

        // 自定义配置会被优先输出
        // 生成app
//        String preTestFilePath = projectPath.getAppProjectPath() + "/src/test/resources/";
        String preTestFilePath = "";
        if (null != projectPath.getAppProjectPath()) {
            focList.add(new FileOutConfig(preTestFilePath + "mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath.getAppProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/mapper/" + tableInfo.getEntityName() + "Mapper"
                            + StringPool.DOT_XML;
                }
            });
            focList.add(new FileOutConfig(preTestFilePath + "api-controller.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getAppProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/controller" + "/" + tableInfo.getEntityName() + "Controller"
                            + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(preTestFilePath + "service.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getAppProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/service" + "/I" + tableInfo.getEntityName() + "Service"
                            + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(preTestFilePath + "serviceImpl.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getAppProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/service/impl" + "/" + tableInfo.getEntityName()
                            + "ServiceImpl" + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(preTestFilePath + "mapper.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getAppProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/dao" + "/" + tableInfo.getEntityName() + "Mapper"
                            + StringPool.DOT_JAVA;
                }
            });
        }

        // 生成实体类model
        if (null != projectPath.getModelProjectPath()) {

            focList.add(new FileOutConfig("entity.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getModelProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/entity" + "/" + tableInfo.getEntityName()
                            + StringPool.DOT_JAVA;
                }
            });
        }

        // 生成api
        if (null != projectPath.getApiProjectPath()) {
            focList.add(new FileOutConfig(preTestFilePath + "api.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getApiProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/api" + "/" + tableInfo.getEntityName() + "Api"
                            + StringPool.DOT_JAVA;
                }
            });
        }

        // 生成client
        if (null != projectPath.getClientProjectPath()) {
			focList.add(new FileOutConfig(preTestFilePath + "client-autoconfigure.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					return projectPath.getClientProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
							+ "/" + captureName(packageInfo[2]) + "RpcAutoConfiguration"
							+ StringPool.DOT_JAVA;
				}
			});

            focList.add(new FileOutConfig(preTestFilePath + "client-constant.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getClientProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            +  "/" + "Constants" + StringPool.DOT_JAVA;
                }
            });

            focList.add(new FileOutConfig(preTestFilePath + "client-feign.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getClientProjectPath() + "/src/main/java/" + StringUtils.join(packageInfo, "/")
                            + "/" + pc.getModuleName()
                            + "/rpc" + "/" + tableInfo.getEntityName() + "Rpc"
                            + StringPool.DOT_JAVA;
                }
            });

            focList.add(new FileOutConfig(preTestFilePath + "spring.factories.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath.getClientProjectPath() + "/src/main/resources/META-INF/spring.factories";
                }
            });
        }

        cfg.setFileOutConfigList(focList);
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String s) {
                if (fileType == FileType.ENTITY) {
                    return true; // entity默认要覆盖
                }
                if (s.contains("entity")) {
                    return true;
                }
                if (s.contains("factories")) {
                    return true;
                }
                if (new File(s).exists()) {
                    return false; // 其他的不存在则创建，不覆盖
                }
                checkDir(s);
                return true;
            }
        });
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = getTemplateConfigByGenerateType();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        String basePackage = "com.lmk.common.";
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(basePackage + "rdbms.entity.BaseModel");
        strategy.setSuperServiceClass(basePackage + "web.rdbms.service.BaseService");
        strategy.setSuperServiceImplClass(basePackage + "web.rdbms.service.impl.BaseServiceImpl");
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setSuperEntityColumns(new String[] { EnumPublicColumn.ID.getCode(),
                EnumPublicColumn.CREATOR_ACCT.getCode(), EnumPublicColumn.CREATOR_NAME.getCode(),
                EnumPublicColumn.CREATE_TIME.getCode(), EnumPublicColumn.UPDATER_ACCT.getCode(),
                EnumPublicColumn.UPDATER_NAME.getCode(), EnumPublicColumn.UPDATE_TIME.getCode(),
                EnumPublicColumn.REMARK.getCode(), EnumPublicColumn.IS_DELETE.getCode() });
        strategy.setLogicDeleteFieldName(EnumPublicColumn.IS_DELETE.getCode());

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new MyFreemarkerTemplateEngine(packageName)); // 自定义输出模板设置
        mpg.execute();
    }

    private static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    @SuppressWarnings("unchecked")
    private static DataSourceConfig getDataSourceConfig() throws IOException {
        Yaml yaml = new Yaml();
        InputStream in = GeneratorUtils_Idea.class.getClassLoader().getResourceAsStream("application.yml");
        Map<String, Object> map = yaml.loadAs(in, Map.class);
        map = ((Map<String, Object>) (((Map<String, Object>) map.get("spring"))).get("datasource"));
        DataSourceConfig dsc = new DataSourceConfig();
        String jdbcUrl = (String) map.get("url");
        dsc.setDriverName((String) map.get("driver-class-name"));
        dsc.setUrl(jdbcUrl);
        dsc.setUsername((String) map.get("username"));
        dsc.setPassword((String) map.get("password"));
        dsc.setSchemaName(getSchemaName(jdbcUrl));
        return dsc;
    }

    private static TemplateConfig getTemplateConfigByGenerateType() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setMapper("mapper.java");
        templateConfig.setEntity(null);
        templateConfig.setController("controller.java");
        templateConfig.setServiceImpl("serviceImpl.java");
        templateConfig.setService("service.java");
        return templateConfig;
    }

    @Getter
    @Setter
    private static class DBTable {
        String tableName;
        String tableComment;

        @Override
        public String toString() {
            return tableName + "[" + tableComment + "]";
        }
    }

    private static int getChineseNum(String val) {
        if (val == null) {
            val = "null";
        }
        String regex = "[\u4e00-\u9fa5|。|，]";
        ArrayList<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(val);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        int size = list.size();
        return size;
    }

    private static int getMaxPrintWidth(List<DBTable> dbTableList) {
        int max = 0;
        for (DBTable t : dbTableList) {
            if (t.toString().length() > max) {
                max = t.toString().length();
            }
        }
        return max;
    }

    private static void printDBTableList(List<DBTable> dbTableList) {
        if (dbTableList.size() == 0) {
            return;
        }
        int spanWidth = getMaxPrintWidth(dbTableList);
        System.out.println(String.format("%0" + (spanWidth * 5 + 6) + "d", 0).replace("0", "-"));
        for (int i = 0; i < dbTableList.size(); i++) {
            System.out.format("\33[32;1m"+ String.format(" %-" + (spanWidth - getChineseNum(dbTableList.get(i).toString())) + "s",
                    dbTableList.get(i).toString()) + "\033[0m");
            if (i % 5 == 4) {
                System.out.println("");
            }
        }
        System.out.println(String.format("\n%0" + (spanWidth * 5 + 6) + "d", 0).replace("0", "-"));
    }

    private static List<DBTable> getBizTableInfo(DataSourceConfig datasouceConfig) {
        JdbcTemplate db = getJDBCTemplate(getDatasource(datasouceConfig));

        return db.query("SELECT TABLE_NAME as tableName, TABLE_COMMENT as tableComment" //
                        + " FROM information_schema.Tables " //
                        + "WHERE TABLE_SCHEMA = '" + datasouceConfig.getSchemaName() + "' " //
                        + " AND INSTR(TABLE_NAME, 'qrtz_') != 1 AND INSTR(TABLE_NAME, 'auth_') != 1 AND INSTR(TABLE_NAME, 'sys_') != 1",
                new BeanPropertyRowMapper<>(DBTable.class));
    }

    private static DataSource getDatasource(DataSourceConfig datasouceConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(datasouceConfig.getDriverName());
        dataSource.setUrl(datasouceConfig.getUrl());
        dataSource.setUsername(datasouceConfig.getUsername());
        dataSource.setPassword(datasouceConfig.getPassword());
        return dataSource;
    }

    private static JdbcTemplate getJDBCTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    private static String getSchemaName(String jdbcUrl) {
        Pattern p = Pattern.compile("\\/(.*?)\\?");
        Matcher m = p.matcher(jdbcUrl);
        while (m.find()) {
            String[] a = m.group(1).split("\\/");
            return a[2];
        }
        throw new MybatisPlusException("JDBC Url 有误！");
    }
}

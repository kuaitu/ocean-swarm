package com.lmk.common.utils;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.base.CaseFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class MyFreemarkerTemplateEngine extends AbstractTemplateEngine {
    // private final String GBK = Charset.forName("GBK").name();

    private final String UTF8 = ConstVal.UTF8;

    private Configuration configuration;

    private String packageName;

    public MyFreemarkerTemplateEngine(String packageName) {
        this.packageName = packageName;
    }

    @SuppressWarnings("deprecation")
    @Override
    public MyFreemarkerTemplateEngine init(ConfigBuilder configBuilder) {
        super.init(configBuilder);
        configuration = new Configuration();
        configuration.setDefaultEncoding(UTF8);
        configuration.setClassForTemplateLoading(FreemarkerTemplateEngine.class, StringPool.SLASH);
        return this;
    }

    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        objectMap.put("packageName", packageName);
        objectMap.put("tableName",
                CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, (String) objectMap.get("entity")));

        createFolder(outputFile);

        Template template = configuration.getTemplate(templatePath);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFile));
        template.process(objectMap, new OutputStreamWriter(fileOutputStream, UTF8));
        fileOutputStream.close();
        logger.debug("templatePath: " + templatePath + ";  outputFile:" + outputFile);
    }

    @Override
    public String templateFilePath(String filePath) {
        StringBuilder fp = new StringBuilder();
        fp.append(filePath).append(".ftl");
        return fp.toString();
    }

    /**
     * ???????????????????????????????????????controller??????????????????????????????mp????????????????????????File.mkdir()??????????????????????????????
     *
     * @author chenwc create 2020???7???7???
     * @param filePath
     */
    private void createFolder(String filePath) {
        File dir = new File(filePath).getParentFile();
        if (!dir.exists()) {
            FileUtil.mkdir(dir);
        }
    }
}

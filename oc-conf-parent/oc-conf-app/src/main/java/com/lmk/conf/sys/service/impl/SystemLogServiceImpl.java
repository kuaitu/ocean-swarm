package com.lmk.conf.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.entity.User;
import com.lmk.common.enums.Constants;
import com.lmk.common.enums.EsTableEnum;
import com.lmk.common.enums.ModuleEnum;
import com.lmk.common.enums.OperateEnum;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import com.lmk.conf.sys.dao.SystemLogMapper;
import com.lmk.conf.sys.entity.EsSystemLog;
import com.lmk.conf.sys.entity.SystemLog;
import com.lmk.conf.sys.repository.EsSystemLogRepository;
import com.lmk.conf.sys.service.ISystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
@Slf4j
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLogMapper, SystemLog> implements ISystemLogService {

	@Autowired
	private EsSystemLogRepository esSystemLogRepository;

	@Override
	public Wrapper<SystemLog> buildWrapper(SystemLog example) {
		QueryWrapper<SystemLog> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public SystemLog findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(SystemLog item) {
		this.save(item);
	}

	@Override
	public void update(SystemLog item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}

	@Override
	public void addOperateLog(OperateEnum operate, ModuleEnum module, ModuleEnum subModule, User user, String srcId, Object... object) {
		EsSystemLog log = buildLog(operate, module, subModule, user, srcId, object);
		esSystemLogRepository.save(log);
	}

	private EsSystemLog buildLog(OperateEnum operate, ModuleEnum module, ModuleEnum subModule, User user, String srcId, Object[] object) {
		EsSystemLog systemLog = new EsSystemLog();

		systemLog.setTable(EsTableEnum.SYSTEM_LOG.getCode());

		if (module != null) {
			systemLog.setModule(module.getCode());
		}
		if (subModule != null) {
			systemLog.setSubModule(subModule.getCode());
		}
		if (operate != null) {
			systemLog.setOperate(operate.getCode());
		}
		if (user != null) {
			systemLog.setCreatorAcct(user.getCreatorAcct());
			systemLog.setCreatorName(user.getCreatorName());
			systemLog.setCreateTime(new Date());
			systemLog.setOrgName(user.getOrgName());
			systemLog.setOrgPath(user.getOrgPath());
		}
		if (StringUtils.isNotBlank(srcId)) {
			systemLog.setSrcId(srcId);
		}

		// 获取模板
		StringBuffer templateName = new StringBuffer();
		templateName.append(systemLog.getModule());
		templateName.append(Constants.PERIOD);
		templateName.append(systemLog.getSubModule());
		templateName.append(Constants.PERIOD);
		templateName.append(systemLog.getOperate());
		String template = getTemplate(templateName.toString());

		if (StringUtils.isNotBlank(template) && object != null && object.length > 0) {
			try {
				systemLog.setContent(MessageFormat.format(template, object));
			} catch (Exception e) {
				log.error("设置日志内容失败：",e.getMessage());
			}
		}
		return systemLog;
	}

	private String getTemplate(String templateName) {
		Properties properties = new Properties();
		// 使用ClassLoader加载properties配置文件生成对应的输入流
		InputStream in = SystemLogServiceImpl.class.getClassLoader().getResourceAsStream("logTemplate.properties");
		// 使用properties对象加载输入流
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			properties.load(br);
		} catch (IOException e) {
			log.error("读取logTemplate.properties文件失败");
		}
		//获取key对应的value值
		String value = properties.getProperty(templateName);
		if (StringUtils.isBlank(value)) {
			log.error("没有找到对应的日志摸板: {}", templateName);
		}
		return value;
	}
}

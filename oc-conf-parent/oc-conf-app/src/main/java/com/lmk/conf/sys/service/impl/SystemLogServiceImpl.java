package com.lmk.conf.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import com.lmk.conf.sys.dao.SystemLogMapper;
import com.lmk.conf.sys.entity.SystemLog;
import com.lmk.conf.sys.service.ISystemLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLogMapper, SystemLog> implements ISystemLogService {
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
}

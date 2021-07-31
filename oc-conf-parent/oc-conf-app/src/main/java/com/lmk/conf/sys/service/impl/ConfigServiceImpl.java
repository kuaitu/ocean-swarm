package com.lmk.conf.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import com.lmk.conf.sys.dao.ConfigMapper;
import com.lmk.conf.sys.entity.Config;
import com.lmk.conf.sys.service.IConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class ConfigServiceImpl extends BaseServiceImpl<ConfigMapper, Config> implements IConfigService {
	@Override
	public Wrapper<Config> buildWrapper(Config example) {
		QueryWrapper<Config> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Config findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Config item) {
		this.save(item);
	}

	@Override
	public void update(Config item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

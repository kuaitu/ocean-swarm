package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.PermissionMapper;
import com.lmk.auth.auth.entity.Permission;
import com.lmk.auth.auth.service.IPermissionService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission> implements IPermissionService {
	@Override
	public Wrapper<Permission> buildWrapper(Permission example) {
		QueryWrapper<Permission> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Permission findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Permission item) {
		this.save(item);
	}

	@Override
	public void update(Permission item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

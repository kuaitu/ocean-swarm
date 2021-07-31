package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.RolePermissionMapper;
import com.lmk.auth.auth.entity.RolePermission;
import com.lmk.auth.auth.service.IRolePermissionService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色权限关系表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
	@Override
	public Wrapper<RolePermission> buildWrapper(RolePermission example) {
		QueryWrapper<RolePermission> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public RolePermission findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(RolePermission item) {
		this.save(item);
	}

	@Override
	public void update(RolePermission item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

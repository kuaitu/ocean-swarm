package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.UserRoleMapper;
import com.lmk.auth.auth.entity.UserRole;
import com.lmk.auth.auth.service.IUserRoleService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	@Override
	public Wrapper<UserRole> buildWrapper(UserRole example) {
		QueryWrapper<UserRole> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public UserRole findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(UserRole item) {
		this.save(item);
	}

	@Override
	public void update(UserRole item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

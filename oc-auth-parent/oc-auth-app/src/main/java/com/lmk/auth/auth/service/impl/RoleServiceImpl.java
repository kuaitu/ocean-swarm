package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.RoleMapper;
import com.lmk.auth.auth.entity.Role;
import com.lmk.auth.auth.service.IRoleService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {
	@Override
	public Wrapper<Role> buildWrapper(Role example) {
		QueryWrapper<Role> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Role findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Role item) {
		this.save(item);
	}

	@Override
	public void update(Role item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

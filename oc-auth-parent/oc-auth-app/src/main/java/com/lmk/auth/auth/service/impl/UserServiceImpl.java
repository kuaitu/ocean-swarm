package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.UserMapper;
import com.lmk.auth.auth.entity.User;
import com.lmk.auth.auth.service.IUserService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {
	@Override
	public Wrapper<User> buildWrapper(User example) {
		QueryWrapper<User> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public User findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(User item) {
		this.save(item);
	}

	@Override
	public void update(User item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.User;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IUserService extends BaseService<User> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	User findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(User item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(User item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.UserRole;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IUserRoleService extends BaseService<UserRole> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	UserRole findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(UserRole item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(UserRole item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

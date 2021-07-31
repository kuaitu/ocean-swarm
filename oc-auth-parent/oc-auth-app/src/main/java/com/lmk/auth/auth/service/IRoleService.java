package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.Role;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IRoleService extends BaseService<Role> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Role findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Role item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Role item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

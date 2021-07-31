package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.RolePermission;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 角色权限关系表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IRolePermissionService extends BaseService<RolePermission> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	RolePermission findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(RolePermission item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(RolePermission item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.Permission;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IPermissionService extends BaseService<Permission> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Permission findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Permission item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Permission item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

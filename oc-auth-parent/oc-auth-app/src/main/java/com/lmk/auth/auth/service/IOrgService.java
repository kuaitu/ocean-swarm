package com.lmk.auth.auth.service;

import com.lmk.auth.auth.entity.Org;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 机构表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IOrgService extends BaseService<Org> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Org findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Org item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Org item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

package com.lmk.conf.sys.service;

import com.lmk.common.web.rdbms.service.BaseService;
import com.lmk.conf.sys.entity.Dictionary;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IDictionaryService extends BaseService<Dictionary> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Dictionary findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Dictionary item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Dictionary item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

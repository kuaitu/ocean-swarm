package com.lmk.conf.sys.service;

import com.lmk.common.web.rdbms.service.BaseService;
import com.lmk.conf.sys.entity.Config;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface IConfigService extends BaseService<Config> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Config findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Config item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Config item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

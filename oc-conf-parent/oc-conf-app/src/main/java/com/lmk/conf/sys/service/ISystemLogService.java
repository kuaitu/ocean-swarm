package com.lmk.conf.sys.service;

import com.lmk.common.web.rdbms.service.BaseService;
import com.lmk.conf.sys.entity.SystemLog;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
public interface ISystemLogService extends BaseService<SystemLog> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	SystemLog findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(SystemLog item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(SystemLog item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

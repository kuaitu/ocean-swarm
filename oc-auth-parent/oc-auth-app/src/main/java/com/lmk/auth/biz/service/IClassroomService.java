package com.lmk.auth.biz.service;

import com.lmk.auth.biz.entity.Classroom;
import com.lmk.common.web.rdbms.service.BaseService;

/**
 * <p>
 * 教室 服务类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
public interface IClassroomService extends BaseService<Classroom> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author lenovo
	 * @param id
	 */
	Classroom findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void create(Classroom item);

	/**
	 * 更新记录
	 *
	 * @author lenovo
	 * @param item
	 */
	void update(Classroom item);

	/**
	 * 删除记录
	 *
	 * @author lenovo
	 * @param id
	 */
	void deleteById(Integer id);
}

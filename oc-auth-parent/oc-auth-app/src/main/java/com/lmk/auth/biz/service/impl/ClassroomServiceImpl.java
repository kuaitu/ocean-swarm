package com.lmk.auth.biz.service.impl;

import com.lmk.auth.biz.entity.Classroom;
import com.lmk.auth.biz.dao.ClassroomMapper;
import com.lmk.auth.biz.service.IClassroomService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 教室 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
@Service
@Transactional
public class ClassroomServiceImpl extends BaseServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {
	@Override
	public Wrapper<Classroom> buildWrapper(Classroom example) {
		QueryWrapper<Classroom> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Classroom findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Classroom item) {
		this.save(item);
	}

	@Override
	public void update(Classroom item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}

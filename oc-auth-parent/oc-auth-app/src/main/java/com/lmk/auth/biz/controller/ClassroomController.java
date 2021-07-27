package com.lmk.auth.biz.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.auth.biz.entity.Classroom;
import com.lmk.auth.biz.service.IClassroomService;
import com.lmk.auth.biz.api.ClassroomApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 教室 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
@Api(tags="教室")
@Controller
public class ClassroomController implements ClassroomApi{
 
	@Autowired
	private IClassroomService service;

	@ApiOperation("分页查询教室记录")
	@Override
	public Ret<IPage<Classroom>> search(PageQuery<Classroom> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询教室详情")
	@Override
	public Ret<Classroom> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建教室记录")
	@Override
	public Ret<Integer> create(Classroom item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新教室记录")
	@Override
	public Ret<Void> updateById(Classroom item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除教室记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有教室记录")
	@Override
	public Ret<List<Classroom>> findAll() {
		return Ret.ok(service.list());
	}
}
package com.lmk.auth.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.api.OrgApi;
import com.lmk.auth.auth.entity.Org;
import com.lmk.auth.auth.service.IOrgService;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="机构表")
@Controller
public class OrgController implements OrgApi{
 
	@Autowired
	private IOrgService service;

	@ApiOperation("分页查询机构表记录")
	@Override
	public Ret<IPage<Org>> search(PageQuery<Org> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询机构表详情")
	@Override
	public Ret<Org> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建机构表记录")
	@Override
	public Ret<Integer> create(Org item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新机构表记录")
	@Override
	public Ret<Void> updateById(Org item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除机构表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有机构表记录")
	@Override
	public Ret<List<Org>> findAll() {
		return Ret.ok(service.list());
	}
}
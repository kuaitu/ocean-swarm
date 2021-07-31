package com.lmk.auth.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.api.RolePermissionApi;
import com.lmk.auth.auth.entity.RolePermission;
import com.lmk.auth.auth.service.IRolePermissionService;
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
 * 角色权限关系表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="角色权限关系表")
@Controller
public class RolePermissionController implements RolePermissionApi{
 
	@Autowired
	private IRolePermissionService service;

	@ApiOperation("分页查询角色权限关系表记录")
	@Override
	public Ret<IPage<RolePermission>> search(PageQuery<RolePermission> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询角色权限关系表详情")
	@Override
	public Ret<RolePermission> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建角色权限关系表记录")
	@Override
	public Ret<Integer> create(RolePermission item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新角色权限关系表记录")
	@Override
	public Ret<Void> updateById(RolePermission item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除角色权限关系表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有角色权限关系表记录")
	@Override
	public Ret<List<RolePermission>> findAll() {
		return Ret.ok(service.list());
	}
}
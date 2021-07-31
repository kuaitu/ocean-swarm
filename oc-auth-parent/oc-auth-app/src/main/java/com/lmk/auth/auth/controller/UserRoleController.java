package com.lmk.auth.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.api.UserRoleApi;
import com.lmk.auth.auth.entity.UserRole;
import com.lmk.auth.auth.service.IUserRoleService;
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
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="用户角色关系表")
@Controller
public class UserRoleController implements UserRoleApi{
 
	@Autowired
	private IUserRoleService service;

	@ApiOperation("分页查询用户角色关系表记录")
	@Override
	public Ret<IPage<UserRole>> search(PageQuery<UserRole> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询用户角色关系表详情")
	@Override
	public Ret<UserRole> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建用户角色关系表记录")
	@Override
	public Ret<Integer> create(UserRole item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新用户角色关系表记录")
	@Override
	public Ret<Void> updateById(UserRole item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除用户角色关系表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有用户角色关系表记录")
	@Override
	public Ret<List<UserRole>> findAll() {
		return Ret.ok(service.list());
	}
}
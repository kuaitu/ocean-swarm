package com.lmk.auth.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.api.UserApi;
import com.lmk.auth.auth.entity.User;
import com.lmk.auth.auth.service.IUserService;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.entity.Dictionary;
import com.lmk.conf.sys.rpc.DictionaryRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="用户表")
@Controller
public class UserController implements UserApi{
 
	@Autowired
	private IUserService service;

	@Autowired
	private DictionaryRpc dictionaryRpc;

	@ApiOperation("分页查询用户表记录")
	@Override
	public Ret<IPage<User>> search(PageQuery<User> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询用户表详情")
	@Override
	public Ret<User> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建用户表记录")
	@Override
	public Ret<Integer> create(User item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新用户表记录")
	@Override
	public Ret<Void> updateById(User item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除用户表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有用户表记录")
	@Override
	public Ret<List<User>> findAll() {
		Ret<List<Dictionary>> all = dictionaryRpc.findAll();
		System.out.println(all);
		return Ret.ok(service.list());
	}
}
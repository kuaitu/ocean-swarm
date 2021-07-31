package com.lmk.conf.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.api.ConfigApi;
import com.lmk.conf.sys.entity.Config;
import com.lmk.conf.sys.service.IConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="系统配置表")
@Controller
public class ConfigController implements ConfigApi{
 
	@Autowired
	private IConfigService service;

	@ApiOperation("分页查询系统配置表记录")
	@Override
	public Ret<IPage<Config>> search(PageQuery<Config> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询系统配置表详情")
	@Override
	public Ret<Config> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建系统配置表记录")
	@Override
	public Ret<Integer> create(Config item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新系统配置表记录")
	@Override
	public Ret<Void> updateById(Config item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除系统配置表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有系统配置表记录")
	@Override
	public Ret<List<Config>> findAll() {
		return Ret.ok(service.list());
	}
}
package com.lmk.conf.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.User;
import com.lmk.common.enums.Constants;
import com.lmk.common.enums.ModuleEnum;
import com.lmk.common.enums.OperateEnum;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.api.SystemLogApi;
import com.lmk.conf.sys.entity.SystemLog;
import com.lmk.conf.sys.service.ISystemLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Api(tags="系统日志表")
@Controller
public class SystemLogController implements SystemLogApi{
 
	@Autowired
	private ISystemLogService service;

	@ApiOperation("分页查询系统日志表记录")
	@Override
	public Ret<IPage<SystemLog>> search(PageQuery<SystemLog> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询系统日志表详情")
	@Override
	public Ret<SystemLog> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建系统日志表记录")
	@Override
	public Ret<Integer> create(SystemLog item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新系统日志表记录")
	@Override
	public Ret<Void> updateById(SystemLog item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除系统日志表记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有系统日志表记录")
	@Override
	public Ret<List<SystemLog>> findAll() {
		return Ret.ok(service.list());
	}

	@ApiOperation("添加操作日志")
	@Override
	public Ret<Void> addOperateLog(String operate, String module, String subModule, String srcId, String agrStr) {
		Assert.notNull(operate, "操作不能为空！");
		Assert.notNull(module, "模块不能为空！");
		Assert.notNull(subModule, "子模块不能为空！");

		OperateEnum operateEnum = OperateEnum.transCode2Enum(operate);
		ModuleEnum moduleEnum = ModuleEnum.transCode2Enum(module);
		ModuleEnum subModuleEnum = ModuleEnum.transCode2Enum(subModule);
		String[] agrs = getAgrs(agrStr);
		service.addOperateLog(operateEnum, moduleEnum, subModuleEnum, new User(), srcId, agrs);
		return Ret.ok();
	}

	@Override
	public Ret<Void> addOperateLog(OperateEnum operate, ModuleEnum module, ModuleEnum subModule, String srcId, String agrStr) {
		String[] agrs = getAgrs(agrStr);
		service.addOperateLog(operate, module, subModule, new User(), srcId, agrs);
		return Ret.ok();
	}

	private String[] getAgrs(String agrStr) {
		if (StringUtils.isNotBlank(agrStr)) {
			return agrStr.split(Constants.AT);
		}
		return new String[0];
	}
}
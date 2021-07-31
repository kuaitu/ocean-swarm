package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.Permission;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/permission")
public interface PermissionApi{
	@ApiOperation("分页查询权限表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<Permission>> search(@RequestBody PageQuery<Permission> q);

	@ApiOperation("查询权限表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Permission> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建权限表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Permission item);

	@ApiOperation("更新权限表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Permission item);

	@ApiOperation("删除权限表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有权限表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Permission>> findAll();
}

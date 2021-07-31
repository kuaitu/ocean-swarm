package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.RolePermission;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色权限关系表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/role_permission")
public interface RolePermissionApi{
	@ApiOperation("分页查询角色权限关系表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<RolePermission>> search(@RequestBody PageQuery<RolePermission> q);

	@ApiOperation("查询角色权限关系表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<RolePermission> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建角色权限关系表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody RolePermission item);

	@ApiOperation("更新角色权限关系表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody RolePermission item);

	@ApiOperation("删除角色权限关系表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有角色权限关系表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<RolePermission>> findAll();
}

package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.Role;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/role")
public interface RoleApi{
	@ApiOperation("分页查询角色表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<Role>> search(@RequestBody PageQuery<Role> q);

	@ApiOperation("查询角色表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Role> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建角色表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Role item);

	@ApiOperation("更新角色表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Role item);

	@ApiOperation("删除角色表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有角色表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Role>> findAll();
}

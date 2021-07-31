package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.UserRole;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/user_role")
public interface UserRoleApi{
	@ApiOperation("分页查询用户角色关系表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<UserRole>> search(@RequestBody PageQuery<UserRole> q);

	@ApiOperation("查询用户角色关系表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<UserRole> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建用户角色关系表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody UserRole item);

	@ApiOperation("更新用户角色关系表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody UserRole item);

	@ApiOperation("删除用户角色关系表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有用户角色关系表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<UserRole>> findAll();
}

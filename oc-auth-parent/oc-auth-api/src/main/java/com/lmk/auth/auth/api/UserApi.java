package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.User;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/user")
public interface UserApi{
	@ApiOperation("分页查询用户表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<User>> search(@RequestBody PageQuery<User> q);

	@ApiOperation("查询用户表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<User> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建用户表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody User item);

	@ApiOperation("更新用户表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody User item);

	@ApiOperation("删除用户表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有用户表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<User>> findAll();
}

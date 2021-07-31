package com.lmk.conf.sys.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.entity.Config;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/sys/config")
public interface ConfigApi{
	@ApiOperation("分页查询系统配置表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<Config>> search(@RequestBody PageQuery<Config> q);

	@ApiOperation("查询系统配置表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Config> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建系统配置表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Config item);

	@ApiOperation("更新系统配置表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Config item);

	@ApiOperation("删除系统配置表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有系统配置表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Config>> findAll();
}

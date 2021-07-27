package com.lmk.auth.biz.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.auth.biz.entity.Classroom;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 教室 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
@RequestMapping("/biz/classroom")
public interface ClassroomApi{
	@ApiOperation("分页查询教室记录")
	@PostMapping("/search.do")
	@ResponseBody
	Ret<IPage<Classroom>> search(@RequestBody PageQuery<Classroom> q);

	@ApiOperation("查询教室详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Classroom> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建教室记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Classroom item);

	@ApiOperation("更新教室记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Classroom item);

	@ApiOperation("删除教室记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有教室记录")
	@PostMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Classroom>> findAll();
}

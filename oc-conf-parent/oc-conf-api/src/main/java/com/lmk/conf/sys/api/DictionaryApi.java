package com.lmk.conf.sys.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.entity.Dictionary;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/sys/dictionary")
public interface DictionaryApi{
	@ApiOperation("分页查询字典表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<Dictionary>> search(@RequestBody PageQuery<Dictionary> q);

	@ApiOperation("查询字典表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Dictionary> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建字典表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Dictionary item);

	@ApiOperation("更新字典表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Dictionary item);

	@ApiOperation("删除字典表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有字典表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Dictionary>> findAll();
}

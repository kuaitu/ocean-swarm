package com.lmk.auth.auth.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.auth.auth.entity.Org;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/auth/org")
public interface OrgApi{
	@ApiOperation("分页查询机构表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<Org>> search(@RequestBody PageQuery<Org> q);

	@ApiOperation("查询机构表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<Org> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建机构表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody Org item);

	@ApiOperation("更新机构表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody Org item);

	@ApiOperation("删除机构表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有机构表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<Org>> findAll();
}

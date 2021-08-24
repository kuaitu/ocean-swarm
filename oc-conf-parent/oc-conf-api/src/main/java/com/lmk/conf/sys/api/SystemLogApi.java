package com.lmk.conf.sys.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.enums.ModuleEnum;
import com.lmk.common.enums.OperateEnum;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import com.lmk.conf.sys.entity.SystemLog;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@RequestMapping("/sys/system_log")
public interface SystemLogApi{
	@ApiOperation("分页查询系统日志表记录")
	@GetMapping("/search.do")
	@ResponseBody
	Ret<IPage<SystemLog>> search(@RequestBody PageQuery<SystemLog> q);

	@ApiOperation("查询系统日志表详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<SystemLog> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建系统日志表记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody SystemLog item);

	@ApiOperation("更新系统日志表记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody SystemLog item);

	@ApiOperation("删除系统日志表记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有系统日志表记录")
	@GetMapping("/findAll.do")
	@ResponseBody 
	Ret<List<SystemLog>> findAll();

    @ApiOperation("添加操作日志")
	@PostMapping("/addOperateLog.do")
	@ResponseBody
    Ret<Void> addOperateLog(
			@RequestParam("operate") String operate,
			@RequestParam("module") String module,
			@RequestParam("subModule") String subModule,
			@RequestParam(value = "srcId", required = false) String srcId,
			@RequestParam(value = "agrStr", required = false) String agrStr);

	@ApiOperation("根据类型添加操作日志")
	@PostMapping("/addOperateLogByType.do")
	@ApiImplicitParams({
			@ApiImplicitParam(name="operate",value="操作",dataType="string", paramType = "query"),
			@ApiImplicitParam(name="module",value="模块",dataType="string", paramType = "query"),
			@ApiImplicitParam(name="subModule",value="子模块",dataType="string", paramType = "query"),
			@ApiImplicitParam(name="srcId",value="模块主键",dataType="string", paramType = "query"),
			@ApiImplicitParam(name="agrStr",value="日志内容",dataType="string", paramType = "query")
	})
	@ResponseBody
	Ret<Void> addOperateLog(
			@RequestParam(value = "operate") OperateEnum operate,
			@RequestParam("module") ModuleEnum module,
			@RequestParam("subModule") ModuleEnum subModule,
			@RequestParam(value = "srcId", required = false) String srcId,
			@RequestParam(value = "agrStr", required = false) String agrStr);
}

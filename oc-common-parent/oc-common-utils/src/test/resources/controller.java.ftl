package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnykx.common.model.vo.PageQuery;
import com.hnykx.common.model.vo.Ret;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

import io.swagger.annotations.ApiOperation;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if packageName??>/${packageName}</#if><#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${tableName}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
  <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${entity}, ${entity}, ${table.serviceName}> {
  <#else>
public class ${table.controllerName} {
  </#if>
	@Autowired
	private ${table.serviceName} service;

	@ApiOperation("分页查询${table.comment!}记录")
	@PostMapping("/search.do")
	public @ResponseBody Ret<IPage<${entity}>> search(@RequestBody PageQuery<${entity}> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询${table.comment!}详情")
	@PostMapping("/findById.do")
	public @ResponseBody Ret<${entity}> findById(@RequestParam Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建${table.comment!}记录")
	@PostMapping("/create.do")
	public @ResponseBody Ret<Integer> create(@RequestBody ${entity} item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新${table.comment!}记录")
	@PostMapping("/updateById.do")
	public @ResponseBody Ret<Void> updateById(@RequestBody ${entity} item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除${table.comment!}记录")
	@PostMapping("/deleteById.do")
	public @ResponseBody Ret<Void> deleteById(@RequestParam Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有${table.comment!}记录")
	@PostMapping("/findAll.do")
	public @ResponseBody Ret<List<${entity}>> findAll() {
		return Ret.ok(service.list());
	}
}
</#if>
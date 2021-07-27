package ${(package.Controller?substring(0,package.Controller?last_index_of('.'))) + ".api"};

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import ${package.Entity}.${entity};

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
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${tableName}<#else>${table.entityPath}</#if>")
<#if kotlin>
interface ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
  <#if superControllerClass??>
public interface ${table.controllerName} extends ${superControllerClass}<${entity}, ${entity}, ${table.serviceName}> {
  <#else>
public interface ${table.entityName + "Api"}{
  </#if>
	@ApiOperation("分页查询${table.comment!}记录")
	@PostMapping("/search.do")
	@ResponseBody
	Ret<IPage<${entity}>> search(@RequestBody PageQuery<${entity}> q);

	@ApiOperation("查询${table.comment!}详情")
	@PostMapping("/findById.do")
	@ResponseBody 
	Ret<${entity}> findById(@RequestParam("id") Integer id);

	@ApiOperation("创建${table.comment!}记录")
	@PostMapping("/create.do")
	@ResponseBody 
	Ret<Integer> create(@RequestBody ${entity} item);

	@ApiOperation("更新${table.comment!}记录")
	@PostMapping("/updateById.do")
	@ResponseBody 
	Ret<Void> updateById(@RequestBody ${entity} item);

	@ApiOperation("删除${table.comment!}记录")
	@PostMapping("/deleteById.do")
	@ResponseBody 
	Ret<Void> deleteById(@RequestParam("id") Integer id);

	@ApiOperation("查询所有${table.comment!}记录")
	@PostMapping("/findAll.do")
	@ResponseBody 
	Ret<List<${entity}>> findAll();
}
</#if>
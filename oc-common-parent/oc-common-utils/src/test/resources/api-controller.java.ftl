package ${package.Controller};

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.rdbms.vo.Ret;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${(package.Controller?substring(0,package.Controller?last_index_of('.'))) + ".api"}.${table.entityName + "Api"};

import io.swagger.annotations.Api;
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
@Api(tags="${table.comment!}")
@Controller
public class ${table.controllerName} implements ${table.entityName + "Api"}{
 
	@Autowired
	private ${table.serviceName} service;

	@ApiOperation("分页查询${table.comment!}记录")
	@Override
	public Ret<IPage<${entity}>> search(PageQuery<${entity}> q) {
		Assert.notNull(q.getStart(), "分页开始页码不能为空！");
		Assert.notNull(q.getLimit(), "分页每页条数不能为空！");
		return Ret.ok(service.search(q));
	}

	@ApiOperation("查询${table.comment!}详情")
	@Override
	public Ret<${entity}> findById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		return Ret.ok(service.findById(id));
	}

	@ApiOperation("创建${table.comment!}记录")
	@Override
	public Ret<Integer> create(${entity} item) {
		Assert.notNull(item, "参数不能为空！");
		service.create(item);
		return Ret.ok(item.getId());
	}

	@ApiOperation("更新${table.comment!}记录")
	@Override
	public Ret<Void> updateById(${entity} item) {
		Assert.notNull(item, "参数不能为空！");
		service.update(item);
		return Ret.ok();
	}

	@ApiOperation("删除${table.comment!}记录")
	@Override
	public Ret<Void> deleteById(Integer id) {
		Assert.notNull(id, "id不能为空！");
		service.deleteById(id);
		return Ret.ok();
	}

	@ApiOperation("查询所有${table.comment!}记录")
	@Override
	public Ret<List<${entity}>> findAll() {
		return Ret.ok(service.list());
	}
}
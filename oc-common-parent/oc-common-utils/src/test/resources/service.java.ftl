package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
	/**
	 * 根据id查询记录详情
	 *
	 * @author ${author}
	 * @param id
	 */
	${entity} findById(Integer id);

	/**
	 * 新增记录
	 *
	 * @author ${author}
	 * @param item
	 */
	void create(${entity} item);

	/**
	 * 更新记录
	 *
	 * @author ${author}
	 * @param item
	 */
	void update(${entity} item);

	/**
	 * 删除记录
	 *
	 * @author ${author}
	 * @param id
	 */
	void deleteById(Integer id);
}
</#if>
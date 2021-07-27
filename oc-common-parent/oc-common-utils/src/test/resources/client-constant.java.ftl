package ${(package.Controller?substring(0,package.Controller?replace('.controller','')?last_index_of('.')))};


/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface Constants {
	//TODO:修改成对应服务名
	String AUTH_SERVICE_NAME = "<#if packageName??>/${packageName}</#if>";
}
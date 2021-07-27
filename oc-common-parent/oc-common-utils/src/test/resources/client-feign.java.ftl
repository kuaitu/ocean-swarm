package ${(package.Controller?substring(0,package.Controller?last_index_of('.'))) + ".rpc"};


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import ${(package.Controller?substring(0,package.Controller?replace('.controller','')?last_index_of('.'))) + ".Constants"};
import ${(package.Controller?substring(0,package.Controller?last_index_of('.'))) + ".api"}.${table.entityName + "Api"};

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
@FeignClient(name = Constants.AUTH_SERVICE_NAME)
@RefreshScope
public interface ${table.entityName + "Rpc"} extends ${table.entityName + "Api"}{
 
}
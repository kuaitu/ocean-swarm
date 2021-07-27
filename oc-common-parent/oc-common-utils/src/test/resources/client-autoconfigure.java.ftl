package ${(package.Controller?substring(0,package.Controller?replace('.controller','')?last_index_of('.')))};

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lmk.common.annotation.EnableFeginTokenPassThrough;
import com.lmk.common.utils.FeignInterceptor;

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
@Configuration
@ComponentScan("${(package.Controller?substring(0,package.Controller?replace('.controller','')?last_index_of('.'))) + ".*.rpc"}")
@EnableFeignClients("${(package.Controller?substring(0,package.Controller?replace('.controller','')?last_index_of('.'))) + ".*.rpc"}")
public class AuthClientAutoConfiguration {
	@Bean
	@ConditionalOnClass({ EnableFeginTokenPassThrough.class })
	public FeignInterceptor feignInterceptor() {
		return new FeignInterceptor();
	}
}
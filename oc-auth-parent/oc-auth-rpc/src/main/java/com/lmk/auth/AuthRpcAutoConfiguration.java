package com.lmk.auth;

import com.lmk.common.annotation.EnableFeginTokenPassThrough;
import com.lmk.common.utils.FeignInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Configuration
@ComponentScan("com.lmk.auth.*.rpc")
@EnableFeignClients("com.lmk.auth.*.rpc")
public class AuthRpcAutoConfiguration {
	@Bean
	@ConditionalOnClass({ EnableFeginTokenPassThrough.class })
	public FeignInterceptor feignInterceptor() {
		return new FeignInterceptor();
	}
}
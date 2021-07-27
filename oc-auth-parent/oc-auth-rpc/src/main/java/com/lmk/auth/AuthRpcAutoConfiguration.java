package com.lmk.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lmk.common.annotation.EnableFeginTokenPassThrough;
import com.lmk.common.utils.FeignInterceptor;


/**
 * <p>
 * 教室 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
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
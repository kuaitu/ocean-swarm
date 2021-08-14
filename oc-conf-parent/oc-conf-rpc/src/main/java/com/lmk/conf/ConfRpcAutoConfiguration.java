package com.lmk.conf;

import com.lmk.common.annotation.EnableFeginTokenPassThrough;
import com.lmk.common.utils.FeignInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Configuration
@ComponentScan({"com.lmk.conf.*.rpc", "com.lmk.common.utils"})
@EnableFeignClients("com.lmk.conf.*.rpc")
public class ConfRpcAutoConfiguration {
	@Bean
	@ConditionalOnClass({ EnableFeginTokenPassThrough.class })
	public FeignInterceptor feignInterceptor() {
		return new FeignInterceptor();
	}
}
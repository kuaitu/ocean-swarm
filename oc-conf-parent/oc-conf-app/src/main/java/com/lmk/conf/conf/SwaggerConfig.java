package com.lmk.conf.conf;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.lmk.common.web.conf.BaseSwaggerConfig;
import com.lmk.common.web.conf.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.lmk.conf")
                .title("ocean配置中心")
                .description("ocean配置中心相关接口文档")
                .contactName("lmk")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}

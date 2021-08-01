package com.lmk.common.web.conf;

import com.lmk.common.annotation.EnableGlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ConditionalOnClass({ EnableGlobalExceptionHandler.class })
@ImportResource(locations= {"classpath:logback-spring.xml"})
public class GlobalExceptionConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}

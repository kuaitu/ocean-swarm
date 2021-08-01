package com.lmk.auth;

import com.lmk.common.annotation.EnableGlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableGlobalExceptionHandler
@SpringBootApplication
@MapperScan("com.lmk.auth.*.dao")
public class OcAuthAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcAuthAppApplication.class, args);
    }

}

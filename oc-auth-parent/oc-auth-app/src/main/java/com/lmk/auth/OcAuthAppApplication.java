package com.lmk.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lmk.auth.*.dao")
public class OcAuthAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcAuthAppApplication.class, args);
    }

}

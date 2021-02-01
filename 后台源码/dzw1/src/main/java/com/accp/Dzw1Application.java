package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.accp.mapper")
public class Dzw1Application {

    public static void main(String[] args) {
        SpringApplication.run(Dzw1Application.class, args);
    }

}

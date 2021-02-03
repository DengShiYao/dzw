package com.accp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.accp.mapper")
//@Import(ObjectMapper.class)
public class Dzw1Application {

    public static void main(String[] args) {
        SpringApplication.run(Dzw1Application.class, args);
    }

}

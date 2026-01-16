package com.wang.zsxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wang.zsxt.comtset.dao")
public class ZsxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsxtApplication.class, args);
    }

}

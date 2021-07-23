package com.jerrypro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@SpringBootApplication
@MapperScan("com.jerrypro.mapper")
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}

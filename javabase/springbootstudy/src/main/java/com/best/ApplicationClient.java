package com.best;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cctv14
 * @data 2023/9/15 21:04
 * @description
 */
@SpringBootApplication
@MapperScan("com.best.mapper")
public class ApplicationClient {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class, args);
    }
}

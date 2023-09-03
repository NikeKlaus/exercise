package com.best;

import io.github.asleepyfish.annotation.EnableChatGPT;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.best.mapper")
@EnableChatGPT
public class JavaLearningCommunity {
    public static void main(String[] args) {
        SpringApplication.run(JavaLearningCommunity.class,args);
    }
}
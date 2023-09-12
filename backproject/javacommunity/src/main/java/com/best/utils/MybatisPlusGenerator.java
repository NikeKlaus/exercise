package com.best.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 逆向工程实现类
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/java_learning_community?&characterEncoding=utf-8&userSSL=false", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("cctv14")
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir()
                            .outputDir(System.getProperty("user.dir") + "/javacommunity/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.best")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/javacommunity/src/main/resources/mapper/mysql"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("commodity");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}

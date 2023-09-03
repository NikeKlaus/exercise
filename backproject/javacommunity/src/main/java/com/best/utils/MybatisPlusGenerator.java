package com.best.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author: maowenxing
 * @date: 2023/6/5
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/java_learning_community?&characterEncoding=utf-8&userSSL=false", "root", "123456")
                .globalConfig(builder -> {//全局配置
                    builder.author("coffeemao") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .outputDir(System.getProperty("user.dir")+"/javacommunity/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {//包配置
                    builder.parent("com.best") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+"/javacommunity/src/main/resources/mapper/mysql"));// 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {//策略配置
                    builder.addInclude("commodity"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}

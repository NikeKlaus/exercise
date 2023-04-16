package com.functioninterface;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author mao
 * @createTime 2023/4/16 11:24
 * @Description: 供给型接口 接受一个输入参数T，返回一个结果R。
 */
public class ApplyFunctionTest {
    @Test
    public void applyApi0416(){
        Function<String, String> apply = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        System.out.println(apply.apply("apply function interface"));

        // lambda 表达式简化
        Function<String,String> lambdaApply = ((s -> {return s;}));
        System.out.println(lambdaApply.apply("lambdaApply"));

    }
}

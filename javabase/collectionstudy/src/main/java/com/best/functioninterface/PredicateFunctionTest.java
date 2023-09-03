package com.best.functioninterface;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author mao
 * @createTime 2023/4/16 10:57
 * @Description: 断言式函数接口：接受一个输入参数T，返回一个布尔值结果。常用于条件判断
 */
public class PredicateFunctionTest {
    @Test
    public void predicateApi0416(){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }

            @Override
            public Predicate<String> negate() {
                return Predicate.super.negate();
            }

            @Override
            public Predicate<String> or(Predicate<? super String> other) {
                return Predicate.super.or(other);
            }
        };
        System.out.println(predicate.test(""));
        System.out.println(predicate.negate());

        // lambda 简化
        Predicate<String> lambdaPredicate = ((str) -> {
            return !str.isEmpty();
        });
        System.out.println(lambdaPredicate.test(""));
    }
}

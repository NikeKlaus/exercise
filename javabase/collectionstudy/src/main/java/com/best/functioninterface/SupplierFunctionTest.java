package com.best.functioninterface;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author mao
 * @createTime 2023/4/16 11:37
 * @Description: 供需型接口函数 无输入参数，返回一个结果T。常用于符合条件时调用获取结果；运行结果提前定义，但不运行。
 */
public class SupplierFunctionTest {
    @Test
    public void supplierApi0416(){
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "get()";
            }
        };
        System.out.println(supplier.get());

        // lambda 表达式简化
        Supplier<Integer> lambdaSupplier = ()->{return 1024;};
        System.out.println(lambdaSupplier.get());
    }
}

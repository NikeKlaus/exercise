package com.best.functioninterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author mao
 * @createTime 2023/4/16 11:32
 * @Description: 消费型接口函数 接受一个输入参数并且无返回值。没有出参，常用于打印、发送短信等消费动作
 */
public class ConsumerFunctionTest {
    @Test
    public void consumerApi0416(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.concat("--->accept"));
            }
        };
        consumer.accept("hello");

        // lambda 表达式简化
        Consumer<String> lambdaConsumer = (String s)->{
            System.out.println(s.concat("--->lambdaConsumer"));
        };
        lambdaConsumer.accept("world");
    }
}

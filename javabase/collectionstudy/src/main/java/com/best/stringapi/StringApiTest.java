package com.best.stringapi;

/**
 * @author mao
 * @createTime 2023/4/18 14:19
 * @Description: String Api 测试类
 */
public class StringApiTest {
    public static void main(String[] args) {
        System.out.println(String.valueOf(new StringBuilder("aA").reverse()).equals("aA"));
    }
}

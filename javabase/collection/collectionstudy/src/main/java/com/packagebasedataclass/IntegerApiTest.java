package com.packagebasedataclass;

import org.junit.Test;

/**
 * @author mao
 * @createTime 2023/4/18 11:12
 * @Description: Integer的Api测试
 */
public class IntegerApiTest {
    @Test
    public void integerCache0418(){
        Integer integer = 10;// private static class IntegerCache


    }

    @Test
    public void charApi0418(){
        // 因为 Unicode 编码采用 2 个字节的编码，UTF-8 是 Unicode 的一种实现
        // 它使用可变长度的字符集进行编码，char c = '中' 是两个字节，所以能够存储。
        char c = 'a';
        c = '好';
        System.out.println(c);
    }
}

package com.api;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author mao
 * @createTime 2023/4/16 10:49
 * @Description: 数组Api测试
 */
public class ArrayApiTest {
    @Test
    public void array0416(){
        // 二维数组的排序，先安装第一个数的降序排序，第一个数相等的情况安装第二个数的升序排序
        int[][] array2 = new int[10][10];
        Arrays.sort(array2, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        // 队列数组，一维数组中存储的是队列，队列中存储字符
        Deque<Character>[] arrayDeques = new ArrayDeque[10];

    }
}

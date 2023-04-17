package com.api;

import org.junit.Test;

import java.util.*;

/**
 * @author mao
 * @createTime 2023/4/16 2:11
 * @Description: ListApiTest List 集合 Api 方法测试
 */
public class ListApiTest {

    @Test
    public void list0416(){
        // 初始化 list，并且添加新的元素
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2)) {{ add(0); }};

        // list 求和
        int sum = list.stream().mapToInt(i -> i).sum();

        // list 转化为数组，打印数组内容，lambda 表达式进行简化
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int[] lambdaArray = list.stream().mapToInt(i -> i).toArray();

        // 整形返回数组的最大值
        int arrayMax = Arrays.stream(array).max().getAsInt();

        // forEach 快速输出
        list.forEach(System.out::println);

        HashSet<Integer> integers = new HashSet<>();
    }

}

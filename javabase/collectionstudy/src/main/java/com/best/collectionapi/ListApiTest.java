package com.best.collectionapi;

import org.junit.Test;

import java.util.*;

/**
 * @author mao
 * @createTime 2023/4/16 2:11
 * @Description: ListApiTest List 集合 Api 方法测试
 */
public class ListApiTest {

    @Test
    public void listBug0418() {
        // 数组静态内部的 ArrayList 类，长度不可变，重新构造之后，移除元素出现数组 长度动态修改
        ArrayList<String> removeList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        for (int i = 0; i < removeList.size(); i++) {
            removeList.remove(i);
        }
        System.out.println(removeList);

        // java 编译器编译之后，JVM 看到的都是 List，泛型附加的类型信息对 JVM 是看不到的，出现类型擦除，只剩下原始数据类型
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);
        System.out.println(list1.getClass() == list2.getClass());
    }

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
        // list.forEach(System.out::println);

        List<Integer> listBug = Arrays.asList(1, 2, 3);
        // listBug.add(3);

    }

}

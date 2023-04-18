package com.api;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * @author mao
 * @createTime 2023/4/16 10:51
 * @Description: Map Api 测试
 */
public class MapApiTest {
    @Test
    public void map0416(){
        // 在新建 map 时候初始化 map,需要带上后面的形参，否则爆 无法将 '<>' 用于匿名内部类
        // var map1 = new HashMap<Integer, Integer>(); var 编译参数是 JDK10+ 提出
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 0);
            put("e", 1);
            put("i", 2);
            put("o", 3);
            put("u", 4);
        }};

        // 获取 map 值集合中的最大值
        Integer maxValue = map.values().stream().max(Integer::compare).get();

        // 获取 map 中 values 最大值对应的 key ， values 相同的话选取较小的 key
        map.entrySet().stream().filter(e-> Objects.equals(e.getValue(),maxValue)).min(Map.Entry.comparingByKey()).get().getKey();


    }
}

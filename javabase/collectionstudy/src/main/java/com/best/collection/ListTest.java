package com.best.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cctv14
 * @data 2023/11/29 22:09
 * @description
 */
public class ListTest {
    @Test
    public void testException(){
        List<Integer> list = new ArrayList<>();

        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0){
                temp.add(integer);
            }
        }
        list.removeAll(temp);
        System.out.println(list);
        try {
            for (Integer el : list) {
                list.remove(el);
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }

        System.out.println(list);

        StringBuilder s = new StringBuilder("acd");
        s.reverse();
        char c = s.charAt(1);
        String s1 = String.valueOf(c);
        System.out.println(s1);
        System.out.println(s);
    }
}

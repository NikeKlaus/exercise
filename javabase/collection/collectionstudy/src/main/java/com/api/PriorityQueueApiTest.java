package com.api;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author: maowenxing
 * @date: 2023/7/25
 */
public class PriorityQueueApiTest {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
        priorityQueue.offer(6);
        priorityQueue.offer(3);
        priorityQueue.offer(5);
        // new PriorityQueue<>((a,b)->b.compareTo(a)); 由大到小弹出，默认由小到大
        System.out.println("PriorityQueue 弹出元素");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        // 优先队列的迭代打印，首部默认最小元素其余按照链表打印
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    private static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int value = o1.compareTo(o2);
            if (value == 0) {
                return 0;
            }
            return value < 0 ? 1 : -1;
        }
    }
}

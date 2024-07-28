package com.best.leetcode;

import java.util.*;

/**
 * @author cctv14
 * @data 2023/12/6 22:18
 * @description
 */
public class Test126 {
    public static void main(String[] args) {
//        List<LinkedList<Integer>> allPlates = new ArrayList<>();
//        Deque<Integer> queue = new ArrayDeque<>();
//        LinkedList<Integer> stack = new LinkedList<>();
//        stack.push(1);
//        String[] strings = {"a"};
//        main_1(strings);
        Solution solution = new Solution();

        System.out.println(Integer.toBinaryString(-729934991));
        System.out.println(Integer.toBinaryString(729934991));

    }

    public static void main_1(String[] args) {
        System.out.println("sasas");
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) {
                    break ok;
                }
            }
        }
    }
}
class Solution {
    public int convertInteger(int A, int B) {
        String sa = Integer.toBinaryString(A);
        String sb = Integer.toBinaryString(-729934991);
        int count = 0;
        if(sa.length() < sb.length()){
            for(int i = 0; i < sb.length() - sa.length(); i++){
                sa = "0" + sa;
            }
        }
        if(sa.length() > sb.length()){
            for(int i = 0; i < sa.length() - sb.length(); i++){
                sb += "0";
            }
        }
        for(int i = 0; i < sb.length(); i++){
            if(sa.charAt(i) != sb.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
package com.best.utils;

import java.util.Scanner;

/**
 * @author cctv14
 * @data 2023/11/15 22:32
 * @description
 */
public class MyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String message = scanner.nextLine();
            if ("exit".equalsIgnoreCase(message)) {
                flag = false;
            } else {
                System.out.println(message);
            }
        }
    }
}

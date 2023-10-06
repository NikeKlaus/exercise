package com.best.behavior;

/**
 * @author cctv14
 * @data 2023/10/6 11:38
 * @description
 */
interface A {
}

class B implements A {

}

public class Main {
    public static void test(A a) {
        System.out.println(a.getClass());
        System.out.println(a.toString());
    }

    public static void main(String[] args) {
        A b = new B();
        test(b);
    }
}
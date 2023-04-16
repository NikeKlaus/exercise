package com.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author mao
 * @createTime 2023/4/16 2:16
 * @Description: ThreadApiTest 线程 Api 方法测试
 */
public class ThreadCreateApiTest {

    private volatile int tickets = 50;

    @Test
    public void threadCreate0416() throws ExecutionException, InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        Mythread3 mythread3 = new Mythread3();

        new Thread(myThread1,"thread").start();

        new Thread(myThread2,"runnable").start();

        FutureTask<String> futureTask = new FutureTask<>(mythread3);
        new Thread(futureTask,"callable1").start();
        new Thread(futureTask,"callable2").start();

        System.out.println(futureTask.get());
    }

    /**
     * 创建线程方法一
     * 继承 Thread 类
     * 重写 run() 包含了业务，多线程考虑酌情加锁
     * 创建对象，对象调用 start() 开启线程
     */
    class MyThread1 extends Thread{
        @Override
        public synchronized void run() {
            // Thread.currentThread().getName() 获取当前线程的名字
            while (true){
                if (tickets <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ tickets -- +"张票");
            }
        }
    }

    /**
     * 创建线程方法二
     * 实现 Runnable 接口
     * 重写 run() 包含了业务，多线程考虑酌情加锁
     * 创建对象，对象作为 Thread 构造参数产生的对象去调用 start() 开启线程
     */
    class MyThread2 implements Runnable{
        @Override
        public synchronized void run() {
            while (true){
                if (tickets <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ tickets -- +"张票");
            }
        }
    }

    /**
     * 创建线程方法三
     * 实现 Callable<String> 接口，形参是 call 的返回值类型
     * 重写 call() 包含了业务，多线程考虑酌情加锁，返回值可通过 FutureTask 的 get() 获取
     * 创建对象，对象作为 FutureTask 的构造参数传入 产生的 FutureTask 对象
     * 这个 FutureTask 对象作为 Thread 的构造参数传入产生的对象调用 start() 开启线程
     */
    class Mythread3 implements Callable<String>{
        @Override
        public synchronized String call() throws Exception {
            while (true){
                if (tickets <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ tickets -- +"张票");
            }
            return "Mythread3 mplements Callable 的 return";
        }
    }
}

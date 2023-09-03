package com.best.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mao
 * @createTime 2023/4/16 16:30
 * @Description: 多线程买票测试，三个窗口包含了 30,30,40 票的资源，实现售卖
 */
public class ThreadSaleTicketTest {
    @Test
    public void testSynchronizedSaleTicket() {
        TicketWindow ticketWindow = new TicketWindow();

        // 旧方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    ticketWindow.synchronizedSaleTicket();
                }
            }
        },"Window A").start();

        // 新方式创建线程
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticketWindow.synchronizedSaleTicket();
            }
        },"Window B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticketWindow.synchronizedSaleTicket();
            }
        },"Window C").start();
    }

    @Test
    public void testLockSaleTicket(){
        TicketWindow ticketWindow = new TicketWindow();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticketWindow.lockSaleTicket();
            }
        }, "Window A").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticketWindow.lockSaleTicket();
            }
        },"Window B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticketWindow.lockSaleTicket();
            }
        },"Window C").start();
    }

}

/**
 * tickets：电影票，volatile 可见性，禁止指令重排序
 * synchronizedSaleTicket()：synchronized 关键字实现安全的买票
 * lockSaleTicket()：lock 实现类实现安全的买票
 */
class TicketWindow {
    private volatile int tickets = 100;
    private final Lock lock = new ReentrantLock(true);

    public void synchronizedSaleTicket() {
        while (tickets > 0) {
            synchronized (TicketWindow.class) {
                System.out.println(Thread.currentThread().getName() + "卖出了第 " + tickets-- + " 张票，剩余了 " + tickets + " 张票");
            }
        }
    }

    /**
     * 存在问题：窗口有票，但是票没有卖完，原因窗口过度的买票，虚假信息穿透 if，将判断条件改为 while 即可解决
     */
    public void lockSaleTicket() {
        lock.lock();
        try {
            while (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第 " + tickets-- + " 张票，剩余了 " + tickets + " 张票");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
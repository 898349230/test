package com.ab.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @classname: PrintN
 * @description:
 * @author: sunxinbo
 * @time: 2021/4/7、22:23
 */
public class PrintN {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        Lock lock = new ReentrantLock();
        Condition curr = lock.newCondition();
//        保存第一个condition
        Condition first = null;
        for (int i = 0; i < n; i++) {
            Condition next = lock.newCondition();
            char c = (char)(i+65);
//            最后一个线程 next condition 是第一线程的curr condition
            if(i == n-1){
                next = first;
            }
            new Thread(new Printer2(lock,curr, next, c)).start();
            Thread.sleep(100);
//            第一个condition
            if(i==0){
                first = curr;
            }
            curr = next;
        }

    }

}
class Printer2 implements Runnable {
    private Lock lock;
    private Condition thisCondition;
    private Condition next;
    private char c;
    public Printer2(Lock lock, Condition thisCondition, Condition next, char c) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.next = next;
        this.c = c;
    }
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.print(c + " ");
                Thread.sleep(10);
                next.signal();
                thisCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}

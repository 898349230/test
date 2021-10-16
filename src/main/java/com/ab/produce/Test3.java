package com.ab.produce;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @classname: Test3
 * @description:
 * @author: sunxinbo
 * @time: 2021/9/16、22:18
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 demo = new Test3();
        demo.print(3);
    }

    public void print(int n){
        Map<Integer, Condition> map = new HashMap<>();
        Lock lock = new ReentrantLock();
        Condition cur = lock.newCondition();
        Condition start = cur;
        for (int i = 0; i < n; i++) {
            Condition next = lock.newCondition();
            map.put(i, cur);
            char c = (char)(i+'A');
            new Thread(new Printer(lock, cur, next, c)).start();
            cur = next;
        }
        start.signal();
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        map.get(0).signal();
    }
}

class Printer implements Runnable{
    private Lock lock;
    private Condition curCondition;
    private Condition nextCondition;
    private char c;

    public Printer(Lock lock, Condition curCondition, Condition nextCondition, char c) {
        this.lock = lock;
        this.curCondition = curCondition;
        this.nextCondition = nextCondition;
        this.c = c;
    }

    @Override
    public void run() {

        try {
            lock.lock();
            System.out.println(c);
            nextCondition.signal();
            curCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

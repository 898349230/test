package concurr2.ch4.othermethod;

import java.util.concurrent.locks.ReentrantLock;

public class Service02 {

    public ReentrantLock lock = new ReentrantLock();

    public void serviceMethod01() {
        try {
            lock.lock();
            System.out.println("Thread " + Thread.currentThread().getName() + " serviceMethod01");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

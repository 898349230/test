package concurr2.ch1.extendhread;

/**
 * start()方法的顺序不一定是线程启动的顺序
 */
public class Test2 {


    public static void main(String[] args) {

        MyThread2 t1 = new MyThread2(1);
        MyThread2 t2 = new MyThread2(2);
        MyThread2 t3 = new MyThread2(3);
        MyThread2 t4 = new MyThread2(4);
        MyThread2 t5 = new MyThread2(5);
        MyThread2 t6 = new MyThread2(6);
        MyThread2 t7 = new MyThread2(7);
        MyThread2 t8 = new MyThread2(8);
        MyThread2 t9 = new MyThread2(9);
        MyThread2 t10 = new MyThread2(10);
        MyThread2 t11 = new MyThread2(11);
        MyThread2 t12 = new MyThread2(12);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();

    }
}

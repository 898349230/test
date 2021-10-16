package com.ab.mypatern.single;

public class Test extends Thread {

    @Override
    public void run() {
//		System.out.println(Singleton2.getInstance().hashCode());
        SingleInstance instance = EnumSingleton.INSTANCE.getInstance();
        System.out.println(instance.hashCode());
    }

    public static void main(String[] args) {

        Test[] test = new Test[100];
        for (int i = 0; i < 100; i++) {
            test[i] = new Test();
        }
        for (Test t : test) {
            t.start();
        }

        SingleInstance instance = EnumSingleton.INSTANCE.getInstance();

    }
}

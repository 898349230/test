package concurr2.ch2.synstatic;

public class ThreadB2 extends Thread {

    private Service2 service;

    public ThreadB2(Service2 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }

}

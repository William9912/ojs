package tests;

class MyThread implements Runnable{
    @Override
    public void run() {

        System.out.println("this is a thread!"+ " "+Thread.currentThread().getName());
    }
}
public class RunableTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.setName("0");
        thread.start();

        Thread thread1 = new Thread(new MyThread());
        thread1.setName("1");
        thread.join();
        thread1.start();

    }
}

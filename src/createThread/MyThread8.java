package createThread;
public class MyThread8 extends Thread{

    public MyThread8(String name,int priority) {
        setName(name);
        setPriority(priority);
        start();
    }

    @Override
    public void run() {
        System.out.println("Name = "+getName()+" - Priority = "+getPriority());
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread8 p1 = new MyThread8("Thread 113", Thread.MIN_PRIORITY);
        MyThread8 p2 = new MyThread8("Thread 114", Thread.NORM_PRIORITY);
        MyThread8 p3 = new MyThread8("Thread 115", Thread.MAX_PRIORITY);
        p1.join();
        p2.join();
        p3.join();
    }
    
}

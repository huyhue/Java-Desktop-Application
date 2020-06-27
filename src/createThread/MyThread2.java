package createThread;

public class MyThread2 implements Runnable {

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ",i=" + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread2 run1 = new MyThread2();
        MyThread2 run2 = new MyThread2();
        MyThread2 run3 = new MyThread2();

        Thread th1 = new Thread(run1);
        th1.setName("Tiến Trình A");
        Thread th2 = new Thread(run2);
        th2.setName("Tiến Trình B");
        Thread th3 = new Thread(run3);
        th3.setName("Tiến Trình C");

        th1.start();
        th2.start();
        th3.start();
    }
}

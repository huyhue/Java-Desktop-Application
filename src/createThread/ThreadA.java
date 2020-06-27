package createThread;
public class ThreadA extends Thread{

    public ThreadA() {
    }

    @Override
    public void run() {
         for (int i = 0; i < 10; i++) {
             System.out.println("A " + i);
        }
    }

}

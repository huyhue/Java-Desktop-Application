package createThread;
public class DeadLockDemo implements Runnable{
    DeadLockDemo assistance = null;  //giam doc co tro ly
    int a=100, b=200;
    public synchronized void changeValues(){
        try {
            Thread.sleep(500);
            a++;
            b++;
        } catch (Exception e) {
        }
    }

    @Override
    public synchronized void run() {
         while (true) {            
             try {
                 System.out.println(Thread.currentThread().getName());
                 System.out.println("a="+a);
                 System.out.println("b="+b);
                 Thread.sleep(500);
             } catch (Exception e) {
                 assistance.changeValues();
             }
        }
    }
    
    public static void main(String[] args) {
        DeadLockDemo person1 = new DeadLockDemo();
        DeadLockDemo person2 = new DeadLockDemo();
        person1.assistance = person2;  //hai giam doc
        person2.assistance = person1;  //lai la tro ly cua nhau
        Thread t1 = new Thread(person1, "Thread-1");
        Thread t2 = new Thread(person2, "Thread-2");
        t1.start();
        t2.start();
        try {
            t1.join(); //t1 will be executed to the end
            t2.join(); //t2 will be executed to the end
        } catch (Exception e) {
        }
    }
    
}

package createThread;
public class DinnerTable {
    static int n;
    static ChopStick[] sticks = new ChopStick[5];
    static Philosopher[] philosophers = new Philosopher[5];
    
    public static void main(String[] args) {
        n = 5;
        int i;
        for (i = 0; i < n; i++) sticks[i] = new ChopStick();
        for (i = 0; i < n; i++) philosophers[i] = new Philosopher(i, sticks[i], sticks[(i+1)%5]);
        for (i = 0; i < n; i++) philosophers[i].start();
    } 
}

class ChopStick {
    boolean ready;

    public ChopStick() {
        ready = true;
    }
    public synchronized void getUp(){
        while (!ready) {            
            try {
                System.out.println("A philosopher is waiting for a choptick.");
                wait();
            } catch (InterruptedException e) {
                System.out.println("An error occured!");
            }
        }
        ready = false;
    }
    public synchronized void getDown(){
        ready = true;
        notify();
    }
}

class Philosopher extends Thread{
    ChopStick leftStick, rightStick;
    int position;

    public Philosopher(int position,ChopStick leftStick, ChopStick rightStick) {
        this.position = position;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }
    public void eat(){
        leftStick.getUp(); rightStick.getUp();
        System.out.println("The " + position + "(th) philosopher is eating");
    }
    public void think(){
        leftStick.getDown(); rightStick.getDown();
        System.out.println("The " + position + "(th) philosopher is thinking\"");
    }

    @Override
    public void run() {
        while (true) {            
            eat();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }
            think();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }
        }
    }
    
    
}

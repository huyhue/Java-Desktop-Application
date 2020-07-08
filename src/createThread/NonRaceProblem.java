package createThread;

import java.util.Date;

public class NonRaceProblem {
    Date d = null;
    long num1=1, num2=0;

    TimeThread t1 = new TimeThread();
    AddThread t2 = new AddThread();
    
    public NonRaceProblem() {
        d = new Date(System.currentTimeMillis());
        randomNumbers();t1.start();t2.start();
    }
    void randomNumbers(){
        num1= Math.round(Math.random()*10000000);
        num2= Math.round(Math.random()*10000000);
    }
    public static void main(String[] args) {
        NonRaceProblem obj = new NonRaceProblem();
    }
    
//Inner class 1: Thread for printing out the time
class TimeThread extends Thread{

    public TimeThread() {
        super();
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println(d);
                this.sleep(1000);
                d=new Date(System.currentTimeMillis());
            } catch (Exception e) {
            }
        }
    }
}
//Inner class 2: Thread for printing out sum of 2 numbers
class AddThread extends Thread{
    public AddThread() {
        super();
    }

    @Override
    public void run() {
        while (true) {            
            try {
                System.out.println(num1+num2);
                 randomNumbers();
                 this.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

}



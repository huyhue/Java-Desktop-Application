/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createThread;

/**
 *
 * @author ASUS
 */
public class MyThread9 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread Start");
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        try {
            myRunnableThread.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThread End");
    }

    public static void main(String[] args) {
        MyThread9 myThread = new MyThread9();

        myThread.start();

        try {
            Thread.sleep(100);
            // Thread.sleep(20000);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable Start");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("MyRunnable End");
    }

}

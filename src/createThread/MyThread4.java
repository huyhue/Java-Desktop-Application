/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createThread;

import static java.lang.Thread.sleep;

/**
 *
 * @author ASUS
 */
public class MyThread4 implements Runnable{
    public static void main(String[] args) {
        MyThread4 myRunnable = new MyThread4();
        Thread th = new Thread(myRunnable);
        th.start();
        System.out.println("This is the main thread");
    }
    public void run(){
        while(true){
            try {
                System.out.println("This is the child Thread");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

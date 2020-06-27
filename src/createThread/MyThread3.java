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
public class MyThread3 extends Thread{
    public static void main(String[] args) {
        MyThread3 th = new MyThread3();
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

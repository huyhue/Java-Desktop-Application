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
public class MyThread6 implements Runnable{
    Thread objTh;

    public MyThread6() {
        System.out.println(Thread.currentThread().getName());
        objTh = new Thread(this);
        System.out.println("Thread objTh isAlive = " + objTh.isAlive());
        objTh.setName("New Thread");
        objTh.start();
    }
    
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
        System.out.println("Thread objTh isAlive = " + objTh.isAlive());
    }
    
    public static void main(String[] args) {
        new MyThread6();
    }
}

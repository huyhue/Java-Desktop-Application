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
public class MyThread extends Thread {

    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ":i= " + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread th1 = new MyThread();
        th1.start();

        MyThread th2 = new MyThread();
        th2.start();

        MyThread th3 = new MyThread();
        th3.start();
    }
}

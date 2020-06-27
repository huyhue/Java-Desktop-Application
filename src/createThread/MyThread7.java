/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createThread;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class MyThread7 extends Thread{
    int num;

    public MyThread7(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println("Count = " + i);
        }
        System.out.println(currentThread().getName());
        System.out.println("Priority = " + getPriority());
    }
    
    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i <= 2; i++) {
            MyThread7 p = new MyThread7(rd.nextInt(5) + 1);
            p.setPriority(rd.nextInt(10)+1);
            p.setName("ct"+i);
            p.start();
        }
    }
    
}

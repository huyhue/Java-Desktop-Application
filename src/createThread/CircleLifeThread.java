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
public class CircleLifeThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread Start");
    }

    public static void main(String[] args) {
        CircleLifeThread myThread = new CircleLifeThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
    }
}

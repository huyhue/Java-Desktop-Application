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
public class CountDownThread extends Thread {

    @Override
    public void run() {
        int count = 10;
        for (int i = count; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Hết giờ");
    }

    public static void main(String[] args) {
        CountDownThread countDownThread = new CountDownThread();
        countDownThread.start();
    }
}

package createThread;

import java.util.Scanner;

/*  Define a thread that count down an int variable from 100 to 0 (that’s decrease 1
every second.). When n equals 0, ask user for continue/stop
program? If continue then re-set n=100, otherwise stop the program
 */
public class ExThread extends Thread {

    public ExThread() {
    }

    static Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        try {
            for (int i = 100; i >= 0; i--) {
                System.out.print(i + ", ");
                Thread.sleep(100);
                if (i == 0) {
                    System.out.println();
                    System.out.print("Do you want to continue/stop program (Y/N) ? ");
                    String str = sc.next().trim();
                    if (str.equalsIgnoreCase("Y")) {
                        i = 101;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ExThread thread = new ExThread();
        thread.start();
    }
}

package createThread;

import java.io.IOException;
import java.nio.CharBuffer;

public class ThreadB implements Runnable{

    public ThreadB() {
    }

    @Override
    public void run() {
         for (int i = 0; i < 10; i++) {
             System.out.println("B " + i);
        }
    }
    
}

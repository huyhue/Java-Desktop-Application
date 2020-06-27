package createThread;
public class MainThread {
    
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();//Extends Thread
        
        ThreadB obj = new ThreadB();//Implement Runnable
        Thread t2 = new Thread(obj);
        
        t1.start();//Day la mot cuoc dua
        t2.start();
    }
    
}

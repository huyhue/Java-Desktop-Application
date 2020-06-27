package createThread;
public class ThreadProperties extends Thread{

    public ThreadProperties(String threadName) {
        super(threadName);
        this.start();
    }
    public static void showProperties(Thread t){
        System.out.println("I'm the " + t.getName() + " thread");
        System.out.println("--My ID" + t.getId());
        System.out.println("--My name:" + t.getName());
        System.out.println("--My priority:" + t.getPriority());
        System.out.println("--My state:" + t.getState());
        System.out.println("--I'm a deamon:" + t.isDaemon());
        System.out.println("--I'm alive:" + t.isAlive());
    }

    @Override
    public void run() {
        showProperties(this);
    }
    
    public static void main(String[] args) {
        System.out.println("Thread count:" + Thread.activeCount());
        Thread t = Thread.currentThread();
        showProperties(t);
        ThreadProperties t1 = new ThreadProperties("son1");
        ThreadProperties t2 = new ThreadProperties("son2");
        System.out.println("Thread count:" + Thread.activeCount());
    }
    
}

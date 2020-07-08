package createThread;

public class ProducerConsumerProblem {
    Store store;
    Producer pro;
    Consumer con;

    public ProducerConsumerProblem() {
        store = new Store();
        pro = new Producer(store);
        con = new Consumer(store);
        pro.start();
        con.start();
    }
    public static void main(String[] args) {
        ProducerConsumerProblem obj = new ProducerConsumerProblem();
        //        run1: no synchronized in put and get
        //-- Product 1 is bought.
        //** Product 1 is made.
        //Customer is waiting for new product.
        //** Product 2 is made.
        //-- Product 2 is bought.
        //** Product 3 is made.
        //-- Product 3 is bought.
        //...
        //        run2: have synchronized in put and get
        //** Product 1 is made.
        //-- Product 1 is bought.
        //** Product 2 is made.
        //-- Product 2 is bought.
        //** Product 3 is made.
        //-- Product 3 is bought.
        //...
    }
     
}

//Store is common resource of 2 threads: producer and customer.
class Store {
    int maxN = 50;   //maxium number of products can be contains int the store 
    long[] a;  //product list
    int n;  //current number of products 

    //A product is simulated as a number.
    public Store() {
        n = 0;
        a = new long[maxN];  //khoi tao
    }

    private boolean empty() {
        return n == 0;
    }

    private boolean full() {
        return n == maxN; 
    }

    public synchronized boolean put(long x) { 
        if (full())  return false;
        a[n++] = x;
        try {
            Thread.sleep(500);
        } catch (Exception e) { }
        return true;
    }

    public synchronized long get() {
        long result = 0;
        if (!empty()) {
            result = a[0];  //get the product at the front of line
            for (int i = 0; i < n - 1; i++)   //shift product up.
                a[i] = a[i + 1];
            n--;
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        return result;
    }
}


//Producer makes a product then puts it to a store.
class Producer extends Thread{
    Store store = null;
    long index = 1;  //index of the product that will be made

    public Producer(Store s) {
        store = s;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                boolean result = store.put(index);
                if (result == true) {
                    System.out.println("** Product "+ (index++) + " is made.");
                }else{
                    System.out.println("Store is full!");
                }
            } catch (Exception e) {
            }
        }
    }
}

//Consumer buys a product from a store.
class Consumer extends Thread{
    Store store = null;

    public Consumer(Store s) {
        store = s;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                long x = store.get();
                if (x > 0) {
                    System.out.println("-- Product " + x + " is bought.");
                }else{
                    System.out.println("Customer is waiting for new product.");
                }
            } catch (Exception e) {
            }
        }
    }
}


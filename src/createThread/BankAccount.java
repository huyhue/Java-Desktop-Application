package createThread;

public class BankAccount {
     
    long amount = 5000000; // Số tiền có trong tài khoản 
     
    public synchronized boolean checkAccountBalance(long withDrawAmount) {
        // Giả lập thời gian đọc cơ sở dữ liệu và kiểm tra tiền
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        if (withDrawAmount <= amount) {
            // Cho phép rút tiền
            return true;
        }
         
        // Không cho phép rút tiền
        return false;
    }
     
    public synchronized void withdraw(String threadName, long withdrawAmount) {
        // In thông tin người rút
        System.out.println(threadName + " check: " + withdrawAmount);
         
        if (checkAccountBalance(withdrawAmount)) {
            // Giả lập thời gian rút tiền và 
            // cập nhật số tiền còn lại vào cơ sở dữ liệu
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             
            amount -= withdrawAmount;
            System.out.println(threadName + " withdraw successful: " + withdrawAmount);
        } else {
            System.out.println(threadName + " withdraw error!");
        }
         
        // In ra số dư tài khoản
        System.out.println(threadName + " see balance: " + amount);
    }
    
    public synchronized void withdrawWhenBalanceEnough(String threadName, long withdrawAmount) {
        // In thông tin người rút
        System.out.println(threadName + " check: " + withdrawAmount);
          
        while (!checkAccountBalance(withdrawAmount)) {
            // Nếu không đủ tiền, thì đợi cho đến khi có đủ tiền thì rút
            System.out.println(threadName + " wait for balance enough");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        // Đủ tiền, hoặc không còn đợi nữa, thì được phép rút
        // Giả lập thời gian rút tiền và 
        // cập nhật số tiền còn lại vào cơ sở dữ liệu
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        amount -= withdrawAmount;
        System.out.println(threadName + " withdraw successful: " + withdrawAmount);
    }
     
    public synchronized void deposit(String threadName, long depositAmount) {
        // In thông tin người nạp tiền
        System.out.println(threadName + " deposit: " + depositAmount);
         
        // Giả lập thời gian nạp tiền và 
        // cập nhật số tiền mới vào cơ sở dữ liệu
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        amount += depositAmount;
         
        // Đánh thức đối tượng đang ngủ và chờ có tiền thì rút
        notify();
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
         
        // Cô vợ muốn rút 10 triệu VND (bạn chú ý khi này tiền không đủ để rút)
        WithdrawThread wifeThread = new WithdrawThread("Wife", bankAccount, 10000000);
        wifeThread.start();
         
        // Anh chồng nạp vào 5 triệu VND
        DepositThread husbandThread = new DepositThread("Husband", bankAccount, 4000000);
        husbandThread.start();
        DepositThread husbandThread1 = new DepositThread("Husband", bankAccount, 2000000);
        husbandThread1.start();
    }
}

//BankAccount này chính là một tài nguyên dùng chung
class WithdrawThread extends Thread { //Thread rút tiền

    String threadName = "";
    long withdrawAmount = 0;
    BankAccount bankAccount;

    public WithdrawThread(String threadName, BankAccount bankAccount, long withdrawAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        bankAccount.withdrawWhenBalanceEnough(threadName, withdrawAmount);
    }
}

class DepositThread extends Thread {  //Thread nạp tiền.
 
    String threadName = "";
    long depositAmount = 0;
    BankAccount bankAccount;
 
    public DepositThread(String threadName, BankAccount bankAccount, long depositAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.depositAmount = depositAmount;
    }
 
    @Override
    public void run() {
        bankAccount.deposit(threadName, depositAmount);
    }
}

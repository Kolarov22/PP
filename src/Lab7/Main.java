package Lab7;

public class Main {
    public static void main(String[] args) {
//        PrintThread printThread = new PrintThread();
//        PrintRunnable printRunnable = new PrintRunnable();
//        Thread t = new Thread(printRunnable);
//
//        printThread.start();
//        t.start();

        BankAccount bankAccount = new BankAccount();
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                bankAccount.deposit(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i =0; i < 6; i++){
                try{
                    bankAccount.withdraw(100);
                    Thread.sleep(2500);
                }
                catch (RuntimeException e){
                    System.out.println(e.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();
        withdrawThread.start();

    }
}

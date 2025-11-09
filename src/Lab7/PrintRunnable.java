package Lab7;

public class PrintRunnable implements Runnable{
    public PrintRunnable() {}

    @Override
    public void run(){
        while(true){
            try {
                System.out.println(java.time.LocalDateTime.now());
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                System.out.println("Runnable interrupted");
                break;
            }
        }
    }
}

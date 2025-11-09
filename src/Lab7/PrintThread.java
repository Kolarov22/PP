package Lab7;

import java.time.LocalDateTime;

public class PrintThread extends Thread{
    public PrintThread() {}

    @Override
    public void run(){
        while(true){
            try {
                System.out.println(LocalDateTime.now());
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                break;
            }
        }
    }

}

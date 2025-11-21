package Lab8;

public class Dispatcher implements Runnable {
    private EventQueue queue;

    public Dispatcher(EventQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true){
            try{
                queue.consume();
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

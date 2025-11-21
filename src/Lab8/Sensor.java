package Lab8;

import java.util.Random;
import java.time.LocalDateTime;

public class Sensor implements Runnable {
    private Integer id;
    private String type;
    private EventQueue queue;
    private Boolean running;
    private final Object pauseLock = new Object();

    public Sensor(Integer id, String type, EventQueue queue) {
        this.id = id;
        this.type = type;
        this.queue = queue;
        this.running = true;
    }

    @Override
    public void run() {
        var random = new Random();

        while(true){
            synchronized (pauseLock) {
                while (!running) {
                    try{
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
            try{
                if (random.nextInt(10) == 5){
                    var event = new SensorEvent(this.id, this.type, LocalDateTime.now());
                    queue.add(event);
                }

                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

    }

    public void resume(){
        synchronized (pauseLock){
            this.running = true;
            pauseLock.notifyAll();
        }

    }

    public void pause(){
        this.running = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }
}

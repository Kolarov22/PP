package Lab8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class EventQueue {
    private final Queue<SensorEvent> eventQueue = new LinkedList<>();
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void add(SensorEvent event) {
        reentrantLock.lock();

        try{
            eventQueue.add(event);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void consume() {
        reentrantLock.lock();

        try{
            SensorEvent event = eventQueue.poll();

            if (event == null) {
                return;
            }

            System.out.println("Event emitted from source " + event.getSource() + " of type " + event.getType() + " at " + event.getTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}

package Lab7.PizzaProducerConsumer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Pizza {
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    private final int id;
    private int numberOfIngredients;

    public Pizza(){
        this.id = atomicCounter.incrementAndGet();
        Random rand = new Random();
        this.numberOfIngredients = rand.nextInt(3, 8);
    }

    public int getId() {
        return id;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }
}

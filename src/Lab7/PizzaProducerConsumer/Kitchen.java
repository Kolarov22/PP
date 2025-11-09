package Lab7.PizzaProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Kitchen {
    private Queue<Pizza> pizzaQueue = new LinkedList<Pizza>();
    private final static int MAX_PIZZAS = 10;

    public synchronized void addPizza(Pizza pizza) {
        while (pizzaQueue.size() >= MAX_PIZZAS) {
            try {
                System.out.println("Kitchen full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pizzaQueue.add(pizza);
        notifyAll();
    }

    public synchronized Pizza removePizza() {
        while (pizzaQueue.isEmpty()) {
            try {
                System.out.println("No pizzas available");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Pizza pizza = pizzaQueue.remove();
        notifyAll();
        return pizza;
    }

}

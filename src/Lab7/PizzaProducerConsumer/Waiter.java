package Lab7.PizzaProducerConsumer;

public class Waiter extends Thread{
    private String name;
    private Kitchen kitchen;
    public Waiter(String name, Kitchen kitchen){
        super();
        this.name = name;
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        while(true){
            try{
                Pizza pizza = kitchen.removePizza();
                System.out.println(name + " delivered pizza " + pizza.getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package Lab7.PizzaProducerConsumer;

public class Cook extends Thread{
    private String name;
    private Kitchen kitchen;

    public Cook(String name, Kitchen kitchen){
        super();
        this.name = name;
        this.kitchen = kitchen;
    }
    @Override
    public void run() {
        while(true){
            try{
                Pizza pizza = new Pizza();
                kitchen.addPizza(pizza);
                System.out.println(name + " cooked pizza " + pizza.getId());
                int sleepTime = 5000 + pizza.getNumberOfIngredients() * 2;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

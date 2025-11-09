package Lab7.PizzaProducerConsumer;

public class PizzaConcurrencyMain {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        Cook cook1 = new Cook("Cook1", kitchen);
        Cook cook2 = new Cook("Cook2", kitchen);
        Cook cook3 = new Cook("Cook3", kitchen);

        Waiter waiter1 = new Waiter("Waiter1", kitchen);
        Waiter waiter2 = new Waiter("Waiter2", kitchen);
        Waiter waiter3 = new Waiter("Waiter3", kitchen);
        Waiter waiter4 = new Waiter("Waiter4", kitchen);

        cook1.start();
        cook2.start();
        cook3.start();

        waiter1.start();
        waiter2.start();
        waiter3.start();
        waiter4.start();
    }
}

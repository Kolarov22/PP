package Lab5;

public class MapDemo {
    public static void main(String[] args) {
        MapImpl<Integer, String> personMap = new MapImpl<>();

        personMap.add(1, "Alice");
        personMap.add(2, "Bob");
        personMap.add(1, "Charlie");
        System.out.println("Map contents:");
        personMap.print();
        System.out.println("Size of map: " + personMap.size());

    }
}

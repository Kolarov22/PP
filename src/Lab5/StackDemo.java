package Lab5;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Person> person = new Stack<>();

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Top of number stack: " + numbers.peek());
        numbers.print();
        System.out.println();

        person.push(new Person("Alice", 25));
        person.push(new Person("Bob", 30));
        System.out.println("Top of person stack: " + person.peek());
        person.print();

    }
}

package Lab6;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static List<Integer> exercise1(List<Integer> numbers){
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .toList();
    }

    public static int exercise2(List<Integer> numbers){
        return numbers.stream()
                .map(x -> x * x)
                .reduce(0, (a,b) -> a + b);
    }

    public static Map<Integer, Integer> exercise3(List<String> strings){
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.length(),
                        s -> 1,
                        (a, b) -> a + b

                ));
    }

    public static List<String> exercise4(List<List<String>> nestedStrings){
        return nestedStrings.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    public static String exercise5(List<Student> students, String group){
        return students.stream()
                .filter(s -> s.getGroup().equals(group))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    public static void exercise6(List<Integer> numbers){
        // Sequential Stream

        LocalTime startSeq = LocalTime.now();

        int seqStreamSum =  numbers.stream()
                .map(x -> x * x)
                .reduce(0, (a,b) -> a + b);

        LocalTime endSeq = LocalTime.now();
        System.out.println("Sequential duration: " + Duration.between(startSeq, endSeq).toMillis() + " ms");

        // Parallel Stream

        LocalTime startPar = LocalTime.now();
        int parStreamSum = numbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (a,b) -> a + b);
        LocalTime endPar = LocalTime.now();
        System.out.println("Parallel duration: " + Duration.between(startPar, endPar).toMillis() + " ms");
    }

    public static List<Student> exercise7(List<Student> students){
        return students.stream()
                .filter(s -> s.getCourses().stream()
                        .anyMatch(c -> c.getCreditPoints() > 5)
                        )
                .toList();
    }

    public static List<Student> exercise8(List<Student> students){
        return students.stream()
                .filter(s -> s.getCourses().stream()
                        .map( c -> c.getCreditPoints())
                        .reduce(0, (a,b) -> a + b) > 30
                ).toList();
    }

    public static Map<Integer, List<Integer>> exercise9(List<Course> courses){
        return courses.stream()
                .collect(Collectors.toMap(
                        c -> c.getCourseId(),
                        c -> c.getStudents().stream()
                                .map(s -> s.getStudentId())
                                .toList()
                        )
                );
    }

    public static List<Student> exercise10(List<Student> students, String group){
        return students.stream()
                .filter(s -> s.getGroup().equals(group))
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }

    public static Map<String, List<Course>> exercise11(List<Student> students){
        return students.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getGroup(),
                                s -> s.getCourses(),
                                (list1, list2) -> {
                                    list1.addAll(list2);
                                    return list1.stream()
                                            .distinct()
                                            .toList();
                                }
                        )
                );
    }


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Exercise 1: " + exercise1(numbers));

        // Test exercise2
        System.out.println("Exercise 2: " + exercise2(numbers));

        // Test exercise3
        List<String> strings = List.of("apple", "banana", "pear", "apple");
        System.out.println("Exercise 3: " + exercise3(strings));

        // Test exercise4
        List<List<String>> nestedStrings = List.of(
                List.of("a", "b", "c"),
                List.of("b", "c", "d")
        );
        System.out.println("Exercise 4: " + exercise4(nestedStrings));

        // Test exercise5
        List<Course> courses = List.of(
                new Course(101, 15, 2023, "Math", new ArrayList<>()),
                new Course(102, 20, 2023, "Science", new ArrayList<>()),
                new Course(103, 10, 2023, "History", new ArrayList<>()),
                new Course(104, 25, 2023, "Physics", new ArrayList<>()),
                new Course(105, 5, 2023, "Art", new ArrayList<>()),
                new Course(106, 30, 2023, "Chemistry", new ArrayList<>())
        );
        List<Student> students = List.of(
                new Student(1, "Alice", "A", new ArrayList<>(List.of(
                       courses.get(0), courses.get(1)
                ))),
                new Student(2, "Bob", "B", new ArrayList<>(List.of(
                        courses.get(2), courses.get(3)
                ))),
                new Student(3, "Charlie", "A", new ArrayList<>(List.of(
                        courses.get(4), courses.get(5)
                )))
        );

        courses.get(0).setStudents(new ArrayList<>(List.of(students.get(0))));
        courses.get(1).setStudents(new ArrayList<>(List.of(students.get(0))));
        courses.get(2).setStudents(new ArrayList<>(List.of(students.get(1))));
        courses.get(3).setStudents(new ArrayList<>(List.of(students.get(1))));
        courses.get(4).setStudents(new ArrayList<>(List.of(students.get(2))));
        courses.get(5).setStudents(new ArrayList<>(List.of(students.get(2))));

        System.out.println("Exercise 5: " + exercise5(students, "A"));

        // Test exercise6
        exercise6(numbers);

        // Test exercise7
        System.out.println("Exercise 7: " + exercise7(students));

        // Test exercise8
        System.out.println("Exercise 8: " + exercise8(students));

        // Test exercise9
        System.out.println("Exercise 9: " + exercise9(courses));

        // Test exercise10
        System.out.println("Exercise 10: " + exercise10(students, "A"));

        // Test exercise11
        System.out.println("Exercise 11: " + exercise11(students));
    }
}

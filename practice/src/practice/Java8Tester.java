package practice;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Vehicle {
    default void print() {
        System.out.println("I am a vehicle!");
    }

    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}

public class Java8Tester {

    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();

        System.out.println("Sort Example START");
        tester.sortingExample(tester);
        System.out.println("Sort Example END");

        System.out.println("Lambda Expressions Example START");
        tester.lambdaExpressions(tester);
        System.out.println("Lambda Expressions Example END");

        System.out.println("Method Reference Example START");
        tester.methodReference();
        System.out.println("Method Reference Example END");

        System.out.println("Functional Interface Example START");
        tester.functionalInterface(tester);
        System.out.println("Functional Interface Example END");

        System.out.println("Default Method Example START");
        tester.functionalInterface(tester);
        Vehicle vehicle = new Car();
        vehicle.print();
        System.out.println("Default Method Example END");

        System.out.println("Stream Example , stream cannot be used twice,START");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream str = new LinkedList(Arrays.asList(arr)).stream();
        str.forEach(System.out::print);
        //str.filter(u->u.equals(5)).forEach(System.out::print);
        System.out.println("Stream Example , stream cannot be used twice,END");

// stream to object array in Java
        Stream<String> currencies = Stream.of("INR", "USD", "GBP", "EUR", "JPY");
        String[] objectArray = currencies.toArray(String[]::new);
        System.out.println("Stream to object array in Java:");
        System.out.println(Arrays.toString(objectArray));

        Stream.of("EURO/INR", "USD/AUD", "USD/GBP", "USD/EURO")
                .filter(e -> e.length() > 7)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toLowerCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();

        // use bigDecimal for monetary calculations
        BigDecimal amount3 = new BigDecimal(String.valueOf(2.15));
        BigDecimal amount4 = new BigDecimal(1.10);
        System.out.println(amount3);
        System.out.println(amount4);
        System.out.println("difference between 2.15 and 1.0 using BigDecmial is: " + (amount3.subtract(amount4)));

        double bill = Arrays.asList(1, 2, 3, 4).stream().map((cost) -> cost + cost).reduce(0, (sum, cost) -> sum + cost);
        System.out.println("Bill" + bill);

    }


    void functionalInterface(Java8Tester tester) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.

        System.out.println("Print all numbers:");

        // pass n as parameter
        tester.eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero

        System.out.println("Print even numbers:");
        tester.eval(list, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.

        System.out.println("Print numbers greater than 3:");
        tester.eval(list, n -> n > 3);
    }

    void eval(List<Integer> list, Predicate<Integer> predicate) {

        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    void methodReference() {
        List<String> names = new ArrayList<>();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        names.forEach(System.out::println);
    }

    void lambdaExpressions(Java8Tester tester) {
        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        // with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // without parenthesis
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // with parenthesis
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    private void sortingExample(Java8Tester tester) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Mahesh ");
        names1.add("Suresh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Mahesh ");
        names2.add("Suresh ");
        names2.add("Ramesh ");
        names2.add("Naresh ");
        names2.add("Kalpesh ");

        System.out.println("Sort using Java 7 syntax: ");

        tester.sortUsingJava7(names1);
        // another way of writing same with comparator
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        System.out.println(names1);
        System.out.println("Sort using Java 8 syntax: ");

        tester.sortUsingJava8(names2);
        // another way of writing same
        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
        System.out.println(names2);
    }

    // sort using java 7
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // sort using java 8
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
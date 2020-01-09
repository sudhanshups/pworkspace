package practice.basic;

import java.util.function.BiFunction;
import java.util.function.Function;

class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class MethodReference3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;

        int result = adder.apply(10, 20);
        System.out.println(result);

        Function<Integer, Integer> mult = (a) -> a * a;
        result = mult.apply(10);

    }
}

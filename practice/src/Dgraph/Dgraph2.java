package Dgraph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Add1Function {
    public static int add(int a) {
        return a + 1;
    }
}

class SquareFunction {
    public static int apply(int a) {
        return a * a;
    }
}

class ParallelCollector extends Thread {
    List<Integer> result;
    List<Integer> input;
    Function<Integer, Integer> f;

    ParallelCollector(List<Integer> input, Function<Integer, Integer> f) {
        this.input = input;
        this.f = f;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void run() {
        result = myMap(input, f);
    }

    public static List<Integer> myMap(List<Integer> input, Function<Integer, Integer> a) {
        List<Integer> out = input.stream().map(u -> a.apply(u)).collect(Collectors.toList());
        return out;
    }
}

public class Dgraph2 {


    public static void main(String[] args) throws InterruptedException {

        Function<Integer, Integer> add1 = Add1Function::add;
        Function<Integer, Integer> square = SquareFunction::apply;

        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println(myMap(input, add1));

        System.out.println(myMap(input, square));

        System.out.println("=================");


        System.out.println(myMapParallel(input, square));
    }

    public static List<Integer> myMap(List<Integer> input, Function<Integer, Integer> a) {
        List<Integer> out = input.stream().map(u -> a.apply(u)).collect(Collectors.toList());
        return out;
    }

    static int threadCount = 4;

    public static List<Integer> myMapParallel(List<Integer> input, Function<Integer, Integer> a) throws InterruptedException {
        if (input == null) {
            return new ArrayList<>();
        }
        int noOfThread = threadCount;
        if (input.size() < noOfThread) {
            noOfThread = input.size();
        }
        int sizeTOProcess = input.size() / noOfThread;

        //5/4
        List<Integer> lists = new ArrayList<>();
        List<Integer> seg = new ArrayList<>();
        List<ParallelCollector> p = new ArrayList<>();

        int i = 0;
        for (Integer u : input) {
            seg.add(u);
            i++;
            if (i == sizeTOProcess) {
                ParallelCollector thread = new ParallelCollector(seg, a);
                p.add(thread);
                thread.start();
                i = 0;
                seg = new ArrayList<>();
            }
        }
        if (seg.size() > 0) {
            ParallelCollector thread = new ParallelCollector(seg, a);
            p.add(thread);
            thread.start();
        }
        System.out.println("number of thread" + p.size());
        for (ParallelCollector x : p) {
            x.join();
        }

        for (ParallelCollector x : p) {
            lists.addAll(x.getResult());
        }
        return lists;
    }

}



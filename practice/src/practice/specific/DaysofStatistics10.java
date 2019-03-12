package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DaysofStatistics10 {

    public static void main(String[] args) throws IOException {
        binomial2();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(in.readLine());

    }

    static void binomial2() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(in);
        int rejects = scanner.nextInt();
        int batch = scanner.nextInt();

        int[] arr = {1, 10, 45};
        // no more than 2 reject
        double probability = 0;
        for (int r = 0; r <= 2; r++) {
            probability += arr[r] * (Math.pow(.12, r)) * (Math.pow(.88, 10 - r));
        }
        System.out.println(String.format("%.3f", probability));

        //at least 2 rejects
        probability = 0;
        for (int r = 0; r <= 1; r++) {
            probability += arr[r] * (Math.pow(.12, r)) * (Math.pow(.88, 10 - r));
        }
        System.out.println(String.format("%.3f", 1 - probability));
    }

    static void binomial1() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(in);
        float ratio = scanner.nextFloat();
        int boy = scanner.nextInt();

        int[] arr = {20, 15, 6, 1};
        double probability = 0;
        for (int r = 3; r <= 6; r++) {
            double p = arr[r - 3] * (Math.pow(109, r) / Math.pow(209, 3)) * (Math.pow(100, 6 - r) / Math.pow(209, 3));
            //System.out.println(p);
            probability += p;
        }
        System.out.println(String.format("%.3f", probability));
    }

    static void standardDeviation() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<Integer> numbers = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        float mean = (numbers.stream().mapToInt(Integer::intValue).sum() + 0.0f) / n;

        float variant = 0;
        for (int i = 0; i < n; i++) {
            variant += (numbers.get(i) - mean) * (numbers.get(i) - mean);
        }
        System.out.println(String.format("%.1f", Math.sqrt(variant / n)));
    }

    static void quartile() throws IOException {
        //median
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<Integer> array = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> fre = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < fre.get(i); j++) {
                numbers.add(array.get(i));
            }
        }

        Collections.sort(numbers);
        n = numbers.size();
        //numbers.stream().forEach(u -> System.out.print(u + " "));
        float q1 = 0, q2 = 0, q3 = 0;
        List<Integer> l = new ArrayList<>();
        List<Integer> u = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i < n / 2)
                l.add(numbers.get(i));
            if (i >= n / 2) {
                if (n % 2 == 1 && i == n / 2)
                    ;
                else
                    u.add(numbers.get(i));
            }
        }
        if (l.size() % 2 == 1)
            q1 += (l.get(l.size() / 2));
        else
            q1 += (l.get(l.size() / 2) + l.get(l.size() / 2 - 1) + 0.0f) / 2;

        if (u.size() % 2 == 1)
            q3 += (u.get(u.size() / 2));
        else
            q3 += (u.get(u.size() / 2) + u.get(u.size() / 2 - 1) + +0.0f) / 2;

        System.out.println(String.format("%.1f", q3 - q1));
    }

    static void weightedMean() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<Integer> numbers = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> weights = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        int weight = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers.get(i) * weights.get(i);
            weight += weights.get(i);
        }
        System.out.println(String.format("%.1f", (sum + 0.0f) / weight));


    }

    static void meanMedianMod() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Integer> numbers = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        DecimalFormat floatFormat = new DecimalFormat("#.#");
        System.out.println(floatFormat.format((numbers.stream().mapToInt(Integer::intValue).sum() + 0.0f) / n));
        //or System.out.print(String.format("%.cf",floating_num);

        Collections.sort(numbers);
        if (n % 2 == 1) {
            System.out.println(numbers.get(n / 2));
        } else {
            System.out.println((numbers.get(n / 2 - 1) + numbers.get(n / 2) + 0.0f) / 2);
        }
        //mod
        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int max = 0;
        long maxFrequeny = 0;
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequeny) {
                maxFrequeny = entry.getValue();
                max = entry.getKey();
            } else if (entry.getValue() == maxFrequeny && max > entry.getKey()) {
                max = entry.getKey();
            }
        }
        System.out.println(max);
    }

}

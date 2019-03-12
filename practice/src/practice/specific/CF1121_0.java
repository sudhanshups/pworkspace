package practice.specific;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// sorting in prority queue with object
public class CF1121_0 {

    static class Pair implements Comparable<Pair> {
        int id;
        int power;

        public Pair(int id, int power) {
            this.id = id;
            this.power = power;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.power <= o.power) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int i;
        int[] power = new int[n];
        for (i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        Map<Integer, Queue<Pair>> schoolToStudent = new HashMap<>();
        int[] schoolOfStudents = new int[n];

        int s;
        for (i = 0; i < n; i++) {
            s = sc.nextInt() - 1;
            schoolOfStudents[i] = s;

            if (!schoolToStudent.containsKey(s)) {
                schoolToStudent.put(s, new PriorityQueue<>());
            }
            Pair p1 = new Pair(i, power[i]);
            schoolToStudent.get(s).add(p1);
        }
        int chosen;
        int minSchool = 0;
        for (i = 0; i < k; i++) {
            chosen = sc.nextInt() - 1;
            Pair pair = schoolToStudent.get(schoolOfStudents[chosen]).peek();
            if (pair.id != chosen) {
                minSchool++;
            }
        }
        System.out.println(minSchool);
    }
}
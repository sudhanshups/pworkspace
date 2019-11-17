package practice.comp;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CF1121_1 {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int i, j;
        int[] tests = new int[n];
        for (i = 0; i < n; i++) {
            tests[i] = sc.nextInt();
        }

        int counter = 0;
        //PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); Desc order
        // PriorityQueue<Integer> heapLow = new PriorityQueue<Integer>(Collections.reverseOrder());

        Queue<Integer> pqueue = new PriorityQueue<>();

        while (counter < n && counter < k) {
            pqueue.add(tests[counter++]);
        }

        int interesting = 0;
        int time = 0;
        int processed= 0;
        while (!pqueue.isEmpty()) {
            time++;

            int x = pqueue.peek();
            if(time>=x){
                pqueue.poll();
                if(counter < n) {
                    pqueue.add(tests[counter++]+time);
                }
                processed++;
                time--;
                continue;
            }

            int q = round(n - processed, n);
            if(time == q){
                interesting ++;
            }
        }

        System.out.println(interesting);
    }

    static int round(int m, int n) {
        double x = (100 * 1.0 * m) / n;
        if ((int) (x + 0.5) > (int) x) {
            return (int) (x + 0.5);
        } else {
            return (int) x;
        }
    }
}
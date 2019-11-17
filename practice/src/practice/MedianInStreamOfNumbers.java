package practice;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//-Find median in a stream of integers and code for it.

public class MedianInStreamOfNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new InputStreamReader(new BufferedInputStream(System.in)));
        int t = sc.nextInt();
        //int[] arr = new int[]{5, 15, 10, 20, 3};
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((u, v) -> v - u);

        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {                     // maintain size property
                maxHeap.add(minHeap.poll());
            }
            System.out.println(maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5);
        }
    }

}

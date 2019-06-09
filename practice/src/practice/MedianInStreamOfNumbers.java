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
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                int temp = maxHeap.poll();
                //max heap will always have more or equall number of element
                if (num < temp) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(temp);
                    temp = num;
                }

                if (minHeap.size() < maxHeap.size()) {
                    minHeap.add(temp);
                } else if (minHeap.peek()<temp){
                    num=minHeap.poll();
                    minHeap.add(temp);
                    maxHeap.add(num);
                }else{
                    maxHeap.add(temp);
                }
            }
            if (minHeap.size() < maxHeap.size()) {
                //System.out.println(i + " - median " + maxHeap.peek() * 1.0);
                System.out.println(maxHeap.peek());

            } else {
                //System.out.println(i + " - median " + (maxHeap.peek() + minHeap.peek()) / 2.0);
                System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0);
            }

        }
    }

}

package practice.specific;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CC {

    static void phonePrice() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 1; k <= t; k++) {
            int x = scanner.nextInt();
            int[] arr = new int[x];
            for (int i = 0; i < x; i++)
                arr[i] = scanner.nextInt();
            int ans = 1;
            Deque<Integer> queue = new LinkedList<>();
            int i = 0;
            queue.add(i++);
            while (i < arr.length) {
                if (!queue.isEmpty() && arr[i] > arr[queue.peekLast()]) {
                    queue.removeLast();
                } else if (!queue.isEmpty() && i - queue.peekFirst() > 5) {
                    queue.removeFirst();
                } else {
                    queue.add(i);
                    i++;
                }
                if (!queue.isEmpty() && (i - queue.peekFirst() == Math.min(5, i))) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 1; k <= t; k++) {
            int x = scanner.nextInt();
            int[] arr = new int[x];
            for (int i = 0; i < x; i++)
                arr[i] = scanner.nextInt();
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                boolean min = true;
                for (int j = i - 1; j >= Math.max(0, i - 5); j--) {
                    if (arr[i] > arr[j]) {
                        min = false;
                        break;
                    }
                }
                if (min)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}

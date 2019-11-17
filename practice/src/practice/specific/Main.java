package practice.specific;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
                    if (arr[i] >= arr[j]) {
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




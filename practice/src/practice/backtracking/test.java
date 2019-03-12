package practice.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(numberofways(3, 1));

        int N;
        N = 2;
        System.out.println(chordCnt(N));
        N = 1;
        System.out.println(chordCnt(N));
        N = 4;
        System.out.println(chordCnt(N));

        count(13);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {

            int W = scanner.nextInt();
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            int r = minCost(arr, n - 1, W);
            System.out.println(r < 0 ? -1 : r);

        }
        scanner.close();
    }

    static int numberofways(int n, int m)
    {
        int dp[][]=new int[n+2][n+2];

        dp[0][n + 1] = 1;

        // Filling the table. k is for numbers
        // greater than or equal that are allowed.
        for (int k = n; k >= m; k--) {

            // i is for sum
            for (int i = 0; i <= n; i++) {

                // initializing dp[i][k] to number
                // ways to get sum using numbers
                // greater than or equal k+1
                dp[i][k] = dp[i][k + 1];

                // if i > k
                if (i - k >= 0)
                    dp[i][k] = (dp[i][k] + dp[i - k][k]);
            }
        }

        return dp[n][m];
    }

    static int chordCnt(int A)
    {

        // n = no of points required
        int n = 2 * A;

        // dp array containing the sum
        int[] dpArray = new int[n + 1];
        dpArray[0] = 1;
        dpArray[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2)
            {
                dpArray[i] += (dpArray[j] *
                        dpArray[i - 2 - j]);
            }
        }

        // returning the required number
        return dpArray[n];
    }

    public static int minCost(int arr[], int n, int W) {
        if (W == 0)
            return 0;

        if (n < 0)
            return Integer.MAX_VALUE;

        if (n + 1 > W || arr[n] == -1)
            return minCost(arr, n - 1, W);

        return Math.min(minCost(arr, n - 1, W), minCost(arr, n, W - (n + 1)) + arr[n]);
    }
    static int count(int n)
    {
        // table[i] will store count of solutions for
        // value i.
        int table[] = new int[n + 1], i;

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // One by one consider given 3
        // moves and update the table[]
        // values after the index greater
        // than or equal to the value of
        // the picked move
        for (i = 3; i <= n; i++)
            table[i] += table[i - 3];
        for (i = 5; i <= n; i++)
            table[i] += table[i - 5];
        for (i = 10; i <= n; i++)
            table[i] += table[i - 10];

        return table[n];
    }
}



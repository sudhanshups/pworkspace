package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartition {

    public static void main(String[] args) {

        int arr[] = {640, 435, 647, 352, 8, 90, 960, 329, 859 };
        int sum[] = new int[arr.length];
//        int arr[] = {10, 10, 10, 10};

        // Calculate size of array.
        int n = arr.length;
        int k = 3;
        System.out.println(partition(arr, n, k));

        System.out.println(partitionBottumUp(arr, n, k));

        ArrayList<Integer> partitions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            partitions.add(arr[i]);
        }
        System.out.println(paint(k, 10, partitions));


    }

    public static int paint(int painter, int timePerUnit, ArrayList<Integer> partitions) {

        int n = partitions.size();
        int mod = 10000003;
        int k = painter;

        int dp[][] = new int[2][n + 1];

        int sum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + partitions.get(i-1)) % mod;
        }

        //k=1
        for (int i = 1; i <= n; i++) {
            dp[1][i] = (dp[1][i - 1] + partitions.get(i-1)) % mod;
        }
        //n=1
        for (int i = 1; i <= 1; i++) {
            dp[i][1] = partitions.get(0) % mod;
        }
        // 2 to k partitions
        for (int i = 2; i <= k; i++) {
            int r = i % 2;
            int prev = ( r == 1 ? 0 : 1);

            for (int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++) {
//                    min = Math.min(min, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                    min = Math.min(min, Math.max(dp[prev][p] , sum[j] - sum[p]));

                }
                dp[r][j] = (int) min;

            }
        }

        return (int) (dp[k%2][n] * 1l * timePerUnit % mod);
    }

    public static int partitionBottumUp(int arr[], int n, int k) {
        int dp[][] = new int[k + 1][n + 1];

        int sum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        //k=1
        for (int i = 1; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + arr[i - 1];
        }
        //n=1
        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }
        // 2 to k partitions
        for (int i = 2; i <= k; i++) {

            for (int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++) {
//                    min = Math.min(min, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                    min = Math.min(min, Math.max(dp[i - 1][p], sum[j] - sum[p]));

                }
                dp[i][j] = min;

            }
        }

        return dp[k][n];
    }

    public static int partition(int arr[], int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n - 1);
        } else if (n == 1) {
            return arr[0];
        }

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

            best = Math.min(best, Math.max(partition(arr, i, k - 1), sum(arr, i, n - 1)));
        }

        return best;
    }

    static int sum(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

}



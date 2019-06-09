package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class InterviewbitBinay {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitBinay ibit = new InterviewbitBinay();
        /* String input = in.readLine();*/

/*        ArrayList<Integer> pages = new ArrayList<>(Arrays.asList(87, 3, 27, 29, 40, 12, 3, 69, 9, 57, 60, 33, 99));
        int students = 3;
        System.out.println(ibit.AllocateBooks(pages, students));
        System.out.println(ibit.AllocateBooksBinarySearch(pages, students));*/


        ArrayList<Integer> board = new ArrayList<>();
        board.addAll(new ArrayList<>(Arrays.asList(1000000, 1000000)));
        System.out.println(ibit.PainterPartition(1, 1000000, board));
        System.out.println(ibit.PainterPartitionBinarySearch(1, 1000000, board));

    }

    public int PainterPartitionBinarySearch(int painter, int timePerUnit, ArrayList<Integer> partitions) {
        int low = partitions.stream().reduce(0, Integer::max);
        int high = partitions.stream().reduce(0, (x, y) -> x + y);

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (noOfPainters(partitions, mid) <= painter) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) (((low) % 10000003) * 1l * (timePerUnit % 10000003) % 10000003);
    }

    private int noOfPainters(ArrayList<Integer> partitions, int unitsPerpainter) {
        int sum = 0;
        int count = 1;
        for (Integer partition : partitions) {
            if (sum + partition > unitsPerpainter) {
                count++;
                sum = partition;
            } else {
                sum += partition;
            }
        }
        return count;
    }


    public int PainterPartition(int painter, int timePerUnit, ArrayList<Integer> partitions) {
        // initialize table
        int mod = 10000003;
        int n = partitions.size();
        int dp[][] = new int[painter + 1][n + 1];

        int sum[] = new int[n + 1];//{0};

        // sum from 1 to i elements of arr
        for (int i = 1; i <= n; i++)
            sum[i] = (int) ((sum[i - 1]) + (partitions.get(i - 1) * 1l * timePerUnit) % mod) % mod;

        //k=1
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum[i];

        // n=1
        for (int i = 1; i <= painter; i++)
            dp[i][1] = (int) (partitions.get(0) * 1l * timePerUnit) % mod;

        // 2 to k partitions
        for (int i = 2; i <= painter; i++) { // 2 to n boards
            for (int j = 2; j <= n; j++) {

                // track minimum
                int best = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum[j] - sum[p]));

                dp[i][j] = best % mod;
            }
        }

        return dp[painter][n];
    }

    /*
   max (min no of pages read by all student)
    */
    int AllocateBooksBinarySearch(ArrayList<Integer> pages, int students) {
        int n = pages.size();
        if (n < students) {
            return -1;
        }
        if (n == 0)
            return 0;

        int low = 0;
        int high = pages.stream().reduce(0, (x, y) -> x + y);
        int minPageRead = Integer.MAX_VALUE;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (canBedistributed(pages, students, mid)) {
                minPageRead = Math.min(minPageRead, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minPageRead;
    }

    boolean canBedistributed(ArrayList<Integer> pages, int students, int pagesPerStudent) {
        int count = 1;
        int pagesCount = 0;
        for (Integer page : pages) {
            if (page > pagesPerStudent) {
                return false;
            }

            if (pagesCount + page > pagesPerStudent) {
                count++;
                pagesCount = page;
                if (count > students)
                    return false;
            } else {
                pagesCount += page;
            }
        }

        return true;
    }

    /*
    max (min no of pages read by all student)
     */
    int AllocateBooks(ArrayList<Integer> pages, int students) {
        int n = pages.size();

        if (n < students) {
            return -1;
        }
        if (n == 0)
            return 0;

        int commutativeArray[] = new int[n + 1];
        commutativeArray[1] = pages.get(0);
        for (int i = 2; i <= n; i++) {
            commutativeArray[i] = commutativeArray[i - 1] + pages.get(i - 1);
        }

        int dp[][] = new int[n + 1][students + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= students; j++) {
                dp[i][j] = -1;
            }
        }

        int minPageRead = Integer.MAX_VALUE;
        for (int i = 1; i <= n && i <= n - (students - 1); i++) {
            int pageRead = 0;
            if (students == 1) {
                pageRead = commutativeArray[n] - commutativeArray[0];
            } else {
                int pageReadBythis = commutativeArray[i] - commutativeArray[0];
                pageRead = Math.max(pageReadBythis,
                        pageReadByStudent(commutativeArray, i + 1, students - 1, n, dp));
            }
            minPageRead = Math.min(minPageRead, pageRead);
        }

        return minPageRead;
    }

    int pageReadByStudent(int[] commutativeArray, int startAt, int students, int n, int[][] dp) {

        int minPageRead = Integer.MAX_VALUE;
        if (dp[startAt][students] != -1)
            return dp[startAt][students];

        for (int i = startAt; i <= n && i <= n - (students - 1); i++) {
            int pageRead = 0;
            if (students == 1) {
                pageRead = commutativeArray[n] - commutativeArray[startAt - 1];
            } else {
                pageRead = Math.max(commutativeArray[i] - commutativeArray[startAt - 1],
                        pageReadByStudent(commutativeArray, i + 1, students - 1, n, dp));
            }
            minPageRead = Math.min(minPageRead, pageRead);
        }
        dp[startAt][students] = minPageRead;
        return dp[startAt][students];
    }


    /**
     * heap
     * height = log2(n), 0 means only root,
     * no of nodes in last level = n- (2^h-1)
     */
    class Point {
        int x;
        int y;
        int dist;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = x * x + y * y;
        }
    }

    /*
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(1, 2)));
        a.add(new ArrayList<>(Arrays.asList(3, 4)));
        a.add(new ArrayList<>(Arrays.asList(-2, -2)));
        a.add(new ArrayList<>(Arrays.asList(3, -3)));
        a.add(new ArrayList<>(Arrays.asList(4, 4)));

        System.out.println(ibit.BClosestPointsToOrigin(a, 4));
     */
    ArrayList<ArrayList<Integer>> BClosestPointsToOrigin(ArrayList<ArrayList<Integer>> A, int B) {
        Queue<Point> maxHeap = new PriorityQueue<>((u, v) -> v.dist - u.dist);//{ //1 to swap,-1,0 to not swap});

        for (ArrayList<Integer> point : A) {
            maxHeap.add(new Point(point.get(0), point.get(1)));
            if (maxHeap.size() > B) {
                maxHeap.poll();
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            ArrayList<Integer> point = new ArrayList<>();
            Point p = maxHeap.poll();
            point.add(p.x);
            point.add(p.y);
            result.add(point);
        }
        return result;

    }

}

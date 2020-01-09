package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterviewbitDP {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitDP ibit = new InterviewbitDP();

        //System.out.println(ibit.lengthOflongestIncreasingDecresingSequence(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 2, 1))));
        //ans 1 2 10 4 2 1
        //System.out.println(ibit.waysToDecode("120"));
        //System.out.println(ibit.climbingStair(3));
        //System.out.println(ibit.chordCount(4));
        //System.out.println(ibit.TusharBirthdayBombs(10, new ArrayList<>(Arrays.asList(8, 8, 6, 5))));
        //System.out.println(ibit.canJump(new ArrayList<>(Arrays.asList(8, 4))));
        //System.out.println(ibit.minJump(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));

//        ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6));
//        System.out.println("Test3 "+ test3);
//        System.out.println(ibit.longestArithmeticSubSequenceN3(test3));
//        System.out.println(ibit.longestArithmeticSubSequenceN2(test3));

//        System.out.println(ibit.NDigitNumbersWithDigitSumS(3, 4));
        //System.out.println(ibit.WaysToColor3xNBoard(10000));
        //System.out.println(ibit.shortestSuperstring(new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"}));

//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 4));
//        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4, 5, 8));
//        System.out.println(ibit.KthManhattanDistanceNeighbourhood(2, new ArrayList<>(Arrays.asList(a, b))));

//        System.out.println(ibit.CoinsInLine(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
//        System.out.println(ibit.countParenth("T&T|F"));

/*        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        System.out.println(ibit.MaxSumWithoutAdjacentElements(lists));*/
        //System.out.println(ibit.findSubsequenceCount("banana","ban"));

        //System.out.println(ibit.InterleavingStrings("USfMSU", "5YgZ9N5mR6ppfggzbzh7HTox85MwFtaIQDHfzJW8vc2G", "5YgUSZf9NM5SmR6Uppfggzbzh7HTox84MwFtaIQDHfzJW8vc2G"));

        //System.out.println(ibit.maxCoins(new int[]{1, 2}));

//      ibit.printAllSubsets(new int[]{1, 2, 3, 4, 5}, 5, 10);

        /*List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(-1)));
        lists.add(new ArrayList<>(Arrays.asList(3, 2)));
        System.out.println(ibit.minimumTotalInTriangle(lists));
*/
/*        System.out.println(ibit.MaxLengthSnake(new int[][]{{9, 6, 5, 2},
                {8, 7, 6, 5},
                {7, 3, 1, 6},
                {1, 1, 1, 7}}));*/

       /* ibit.maxRectangleWith0Sum(new int[][]{{1, 2, 3},
                {-3, -2, -1},
                {1, 7, 5}}, 3, 3);*/

/*        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        printMaxSubSquare(M);*/
        System.out.println("Maximum area is " + maxHistogramArea(new int[]{6, 2, 5, 4, 5, 1, 6}, 7));

    }

    static int maxHistogramArea(int input[], int n) {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> stack = new Stack<>();
        int top_val;     // Top of stack
        int max_area = 0;
        int area = 0;    // Initialize area with current top
        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack,
            // push it to stack
            if (stack.empty() || input[stack.peek()] <= input[i])
                stack.push(i++);

            else {
                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
                top_val = input[stack.peek()];
                stack.pop();
                if (!stack.empty())
                    area = top_val * (i - stack.peek() - 1);
                else
                    area = top_val * i;
                max_area = Math.max(area, max_area);
            }
        }

        // Now pop the remaining bars from stack and calculate
        // area with every popped bar as the smallest bar
        while (!stack.empty()) {

            top_val = input[stack.peek()];
            stack.pop();
            if (!stack.empty())
                area = top_val * (i - stack.peek() - 1);
            else
                area = top_val * i;
            max_area = Math.max(area, max_area);

        }
        return max_area;
    }

    static void printMaxSubSquare(int M[][]) {
        int i, j;
        int R = M.length;         //no of rows in M[][]
        int C = M[0].length;     //no of columns in M[][]
        int S[][] = new int[R][C];

        int max_of_s, max_i, max_j;

        for (i = 0; i < R; i++)
            S[i][0] = M[i][0];
        for (j = 0; j < C; j++)
            S[0][j] = M[0][j];

        for (i = 1; i < R; i++) {
            for (j = 1; j < C; j++) {
                if (M[i][j] == 1)
                    S[i][j] = Math.min(S[i][j - 1],
                            Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                else
                    S[i][j] = 0;
            }
        }
        max_of_s = S[0][0];
        max_i = 0;
        max_j = 0;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println("Maximum size sub-matrix is: ");
        for (i = max_i; i > max_i - max_of_s; i--) {
            for (j = max_j; j > max_j - max_of_s; j--) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void maxRectangleWith0Sum(int arr[][], int row, int col) {
        int temp[] = new int[row];
        // Variables to store the final output
        int fup = 0, fdown = 0, fleft = 0, fright = 0;
        int up = 0, down = 0;
        int startEnd[] = new int[2];
        int maxl = Integer.MIN_VALUE;

        for (int left = 0; left < col; left++) {
            for (int i = 0; i < row; i++)
                temp[i] = 0;

            for (int right = left; right < col; right++) {
                // Calculate sum between current left and right for every row 'i'
                for (int i = 0; i < row; i++)
                    temp[i] += arr[i][right];

                // Find largest subarray with 0 sum in temp[]. The sumZero() function also sets values of start and finish.
                boolean sum = sumZero(temp, startEnd, row);
                up = startEnd[0];
                down = startEnd[1];
                int ele = (down - up + 1) * (right - left + 1);

                if (sum && ele > maxl) {
                    fup = up;
                    fdown = down;
                    fleft = left;
                    fright = right;
                    maxl = ele;
                }
            }
        }

        // If there is no change in boundaries
        // than check if a[0][0] is 0
        // If it not zero then print
        // that no such zero-sum sub-matrix exists
        if (fup == 0 && fdown == 0 && fleft == 0 && fright == 0 && arr[0][0] != 0) {
            System.out.print("No zero-sum sub-matrix exists");
        }

        for (int j = fup; j <= fdown; j++) {
            for (int i = fleft; i <= fright; i++)
                System.out.print(arr[j][i] + " ");
            System.out.println();
        }
    }

    private boolean sumZero(int temp[], int[] startEnd, int n) {
        Map<Integer, Integer> presum = new HashMap<>();
        int sum = 0;
        int max_length = 0;

        for (int i = 0; i < n; i++) {
            sum += temp[i];
            if (temp[i] == 0 && max_length == 0) {
                startEnd[0] = i;
                startEnd[1] = i;
                max_length = 1;
            }
            if (sum == 0) {
                if (max_length < i + 1) {
                    startEnd[0] = 0;
                    startEnd[1] = i;
                }
                max_length = i + 1;
            }

            if (presum.get(sum) != null) {
                int old = max_length;
                max_length = Math.max(max_length, i - presum.get(sum));

                if (old < max_length) {
                    // If max_length is updated then enter and update start and end point of array
                    startEnd[0] = presum.get(sum) + 1;
                    startEnd[1] = i;
                }
            } else
                presum.put(sum, i);
        }
        // Return true if max_length is non-zero
        return (max_length != 0);
    }

    public int MaxLengthSnake(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int l = 1;
                if (i == 0 && j == 0) {
                    l = Math.max(1, l);
                } else if (i == 0 || (j != 0 && Math.abs(grid[i][j - 1] - grid[i][j]) == 1)) {
                    l = Math.max(res[i][j - 1] + 1, l);
                } else if (j == 0 || (i != 0 && Math.abs(grid[i][j] - grid[i - 1][j]) == 1)) {
                    l = Math.max(res[i - 1][j] + 1, l);
                }
                res[i][j] = l;
                ans = Math.max(l, ans);
            }
        }
        return ans;
    }

    public int minimumTotalInTriangle(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //int pre = j == 0 ? Integer.MAX_VALUE : triangle.get(i + 1).get(j - 1);
                int cur = triangle.get(i + 1).get(j);
                int next = j == triangle.get(i + 1).size() - 1 ? Integer.MAX_VALUE : triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(Math.min(next, cur), next));
            }
        }
        return triangle.get(0).get(0);
    }


    // A Java program to count all subsets with given sum.
    // dp[i][j] is going to store true if sum j is possible with array elements from 0 to i.
    static boolean[][] dp;

    static void display(ArrayList<Integer> v) {
        System.out.println(v);
    }

    // A recursive function to print all subsets with the help of dp[][]. Vector p[] stores current subset.
    private void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum] is true.
        if (i == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[i]);
            display(p);
            p.clear();
            return;
        }

        // If sum becomes 0
        if (i == 0 && sum == 0) {
            display(p);
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring current element.
        if (dp[i - 1][sum]) {// Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i - 1, sum, b);
        }

        // If given sum can be achieved after considering current element.
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i - 1, sum - arr[i], p);
        }
    }

    // Prints all subsets of arr[0..n-1] with sum 0.
    void printAllSubsets(int arr[], int n, int sum) {
        if (n == 0 || sum < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] ||
                        dp[i - 1][j - arr[i]])
                        : dp[i - 1][j];
        if (dp[n - 1][sum] == false) {
            System.out.println("There are no subsets with" +
                    " sum " + sum);
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n - 1, sum, p);
    }

    //evelynn.gitbooks.io/google-interview/burst_balloons.html
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

    //http://buttercola.blogspot.com/2016/01/leetcode-best-time-to-buy-and-sell.html
    int InterleavingStrings(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        if (m + n != C.length())
            return 0;
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (B.charAt(j - 1) == C.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (A.charAt(i - 1) == C.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                // Current character of C matches with current character of A,
                // but doesn't match with current character of B
                else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    //matching with last of A and last of B
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n] ? 1 : 0;
    }


    int findSubsequenceCount(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) != S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    int longestIncreasingSubSequence(ArrayList<Integer> A) {
        int[] arr = new int[A.size()];
        Arrays.fill(arr, 1);
        int max = 1;
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i) && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
                max = Math.max(max, arr[i]);
            }
        }

        return max;
    }

    int LongestRepeatedSubsequence(String a) {
        String b = a;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    int LongestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    int editDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) { //insert
                    dp[i][j] = j;
                } else if (j == 0) {//remove
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    //2 rows, we first converting it to once row
    int MaxSumWithoutAdjacentElements(ArrayList<ArrayList<Integer>> arr) {
        int[] maxArr = new int[arr.get(0).size()];
        for (int i = 0; i < arr.get(0).size(); i++) {
            maxArr[i] = Math.max(arr.get(0).get(i), arr.get(1).get(i));
        }
        int incl = maxArr[0];
        int excl = 0;
        int excl_new;
        for (int i = 1; i < maxArr.length; i++) {
            excl_new = (incl > excl) ? incl : excl;
            incl = excl + maxArr[i];
            excl = excl_new;
        }
        return Math.max(incl, excl);
    }

    int countParenth(String A) {
        int mod = 1003;
        int n = A.length() / 2 + 1;
        char symb[] = new char[n];
        char oper[] = new char[A.length() / 2];
        int i = 0, j = 0;
        for (i = 0; i < A.length(); i = i + 2) {
            symb[j++] = A.charAt(i);
        }
        j = 0;
        for (i = 1; i < A.length(); i = i + 2) {
            oper[j++] = A.charAt(i);
        }
        int F[][] = new int[n][n];
        int T[][] = new int[n][n];
        for (i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }

        for (int gap = 1; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int k = i; k < gap + i; k++) {
                    int tik = (T[i][k] + F[i][k]) % mod;  // Store Total[i][k] and Total[k+1][j]
                    int tkj = (T[k + 1][j] + F[k + 1][j]) % mod;

                    if (oper[k] == '&') {
                        T[i][j] += (T[i][k] * T[k + 1][j]) % mod;
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]) % mod;
                    }
                    if (oper[k] == '|') {
                        F[i][j] += (F[i][k] * F[k + 1][j]) % mod;
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]) % mod;
                    }
                    if (oper[k] == '^') {
                        T[i][j] += (F[i][k] * T[k + 1][j] +
                                T[i][k] * F[k + 1][j]) % mod;
                        F[i][j] += (T[i][k] * T[k + 1][j] +
                                F[i][k] * F[k + 1][j]) % mod;
                    }
                    T[i][j] = T[i][j] % mod;
                    F[i][j] = F[i][j] % mod;
                }
            }
        }
        return T[0][n - 1];
    }

    int CoinsInLine(ArrayList<Integer> coins) {
        int arr[][] = new int[coins.size()][coins.size()];
        int x, y, z, n = coins.size();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                x = ((i + 2) <= j) ? arr[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? arr[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? arr[i][j - 2] : 0;
                arr[i][j] = Math.max(coins.get(i) + Math.min(x, y), coins.get(j) + Math.min(y, z));
            }
        }
        return arr[0][n - 1];
    }


    public ArrayList<ArrayList<Integer>> KthManhattanDistanceNeighbourhood(int A, ArrayList<ArrayList<Integer>> B) {
        int n = B.size(), m = B.get(0).size(), min = Integer.MIN_VALUE;

        int[][][] dp = new int[n][m][A + 1];
        for (int k = 0; k <= A; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        dp[i][j][k] = B.get(i).get(j);
                    } else {
                        int cur = min;
                        if (i > 0) cur = Math.max(cur, dp[i - 1][j][k - 1]);
                        if (j > 0) cur = Math.max(cur, dp[i][j - 1][k - 1]);
                        if (i < n - 1) cur = Math.max(cur, dp[i + 1][j][k - 1]);
                        if (j < m - 1) cur = Math.max(cur, dp[i][j + 1][k - 1]);
                        dp[i][j][k] = Math.max(cur, dp[i][j][k - 1]);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> c = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                c.add(dp[i][j][A]);
            }
            res.add(c);
        }
        return res;
    }

    /*Time Complexity: O(N^2 (2^N + W)), where N is the number of words, and W is the maximum length of each word.
    Space Complexity: O(N (2^N + W))*/
    public String shortestSuperstring(String[] A) {
        int N = A.length;

        // Populate overlaps
        int[][] overlaps = new int[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (i != j) {
                    int m = Math.min(A[i].length(), A[j].length());
                    for (int k = m; k >= 0; --k)
                        if (A[i].endsWith(A[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                }

        // dp[mask][i] = most overlap with mask, ending with ith element
        int[][] dp = new int[1 << N][N];
        int[][] parent = new int[1 << N][N];
        for (int mask = 0; mask < (1 << N); ++mask) {
            Arrays.fill(parent[mask], -1);

            for (int bit = 0; bit < N; ++bit)
                if (((mask >> bit) & 1) > 0) {
                    // Let's try to find dp[mask][bit].  Previously, we had
                    // a collection of items represented by pmask.
                    int pmask = mask ^ (1 << bit);
                    if (pmask == 0) continue;
                    for (int i = 0; i < N; ++i)
                        if (((pmask >> i) & 1) > 0) {
                            // For each bit i in pmask, calculate the value
                            // if we ended with word i, then added word 'bit'.
                            int val = dp[pmask][i] + overlaps[i][bit];
                            if (val > dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                }
        }

        // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
        // Reconstruct answer, first as a sequence 'perm' representing
        // the indices of each word from left to right.

        int[] perm = new int[N];
        boolean[] seen = new boolean[N];
        int t = 0;
        int mask = (1 << N) - 1;

        // p: the last element of perm (last word written left to right)
        int p = 0;
        for (int j = 0; j < N; ++j)
            if (dp[(1 << N) - 1][j] > dp[(1 << N) - 1][p])
                p = j;

        // Follow parents down backwards path that retains maximum overlap
        while (p != -1) {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= 1 << p;
            p = p2;
        }

        // Reverse perm
        for (int i = 0; i < t / 2; ++i) {
            int v = perm[i];
            perm[i] = perm[t - 1 - i];
            perm[t - 1 - i] = v;
        }

        // Fill in remaining words not yet added
        for (int i = 0; i < N; ++i)
            if (!seen[i])
                perm[t++] = i;

        // Reconstruct final answer given perm
        StringBuilder ans = new StringBuilder(A[perm[0]]);
        for (int i = 1; i < N; ++i) {
            int overlap = overlaps[perm[i - 1]][perm[i]];
            ans.append(A[perm[i]].substring(overlap));
        }

        return ans.toString();
    }


    public static class Triplet {
        int a, b, c;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Triplet)) {
                return false;
            }
            Triplet triplet = (Triplet) o;
            if (a != triplet.a || b != triplet.b) {
                return false;
            }
            return c == triplet.c;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isValid(Triplet other) {
            return other.a != a && b != other.b && c != other.c;
        }

        public static List<Triplet> generateAllValidSingleTriple() {
            List<Triplet> ans = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i != j) {
                        for (int k = 0; k < 4; k++) {
                            if (k != j) {
                                ans.add(new Triplet(i, j, k));
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static int WaysToColor3xNBoard(int n) {
        /**Another approach You have to generate all the outcomes for n=1.
         long color3=24;
         long color2=12;

         for(int i=2;i<=A;i++){
         long temp=color3;
         color3=(11*color3+10*color2)%1000000007;
         color2=(5*temp+7*color2)%1000000007;
         }
         long ans=(color2+color3)%1000000007;

         return (int)ans;
         */
        Map<Triplet, Integer>[] box = new HashMap[2];
        box[0] = new HashMap<>();
        box[1] = new HashMap<>();
        List<Triplet> all = Triplet.generateAllValidSingleTriple();
        int j = 0;
        for (Triplet triplet : all) {
            box[j].put(triplet, 1);
        }
        for (int i = 2; i <= n; i++) {
            j = (j + 1) % 2;
            for (Triplet current : all) {
                int sum = 0;
                for (Triplet prev : all) {
                    if (current.isValid(prev)) {
                        sum = (sum + box[(j + 1) % 2].get(prev)) % 1000000007;

                    }
                }
                box[j].put(current, sum);
            }
        }
        int sum = 0;
        for (Integer trp : box[(n + 1) % 2].values()) {
            sum = (sum + trp) % 1000000007;
        }
        return sum;
    }

    //==============
    static int ways[][];

    public int NDigitNumbersWithDigitSumS(int n, int s) {
        ways = new int[n + 1][s + 1];
        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < ways[0].length; j++) {
                ways[i][j] = -1;
            }
        }
        int ans = 0;
        // Traverse through every digit from 1 to 9 and count numbers beginning with it
        for (int i = 1; i <= 9; i++)
            if (s - i >= 0) {
                ans += countRec(n - 1, s - i);
                ans %= 1000000007;
            }
        return ans;
    }

    private int countRec(int n, int sum) {
        // Base case
        if (n == 0)
            return sum == 0 ? 1 : 0;
        // If this subproblem is already evaluated, return the evaluated value
        if (ways[n][sum] != -1)
            return ways[n][sum];
        int ans = 0;
        for (int i = 0; i < 10; i++)
            if (sum - i >= 0) {
                ans += countRec(n - 1, sum - i);
                ans %= 1000000007;
            }
        return ways[n][sum] = ans;
    }
    //========//

    public int longestArithmeticSubSequenceN2(final List<Integer> A) {
        if (A == null) {
            return 0;
        } else if (A.size() < 3) {
            return A.size();
        }

        Map<Integer, Integer>[] DiffToCount = new HashMap[A.size()];
        DiffToCount[0] = new HashMap<>();
        for (int i = 1; i < A.size(); i++) {
            DiffToCount[i] = new HashMap<>();

            for (int j = i - 1; j >= 0; j--) {
                int diff = A.get(i) - A.get(j);
                if (DiffToCount[j].containsKey(diff)) { //there is some numbers already satisfying this AP

                    if (!DiffToCount[i].containsKey(diff)) { // check is we don't have any AP
                        DiffToCount[i].put(diff, DiffToCount[j].get(diff) + 1);
                    } else if (DiffToCount[i].get(diff) < DiffToCount[j].get(diff)) { //We have an AP with given Diff,look for bigger one
                        DiffToCount[i].put(diff, DiffToCount[j].get(diff));
                    }

                } else if (!DiffToCount[i].containsKey(diff)) {
                    DiffToCount[i].put(diff, 2);
                }
            }
        }

        //find the max ap length with any diff.
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            for (Integer diff : DiffToCount[i].keySet()) {
                max = Math.max(max, DiffToCount[i].get(diff));
            }
        }
        return max;
    }

    public int longestArithmeticSubSequenceN3(final List<Integer> A) {
        if (A == null) {
            return 0;
        } else if (A.size() < 3) {
            return A.size();
        }

        int longestSubSeq = 0;
        for (int i = 0; i < A.size() - 1; i++) {

            for (int j = i + 1; j < A.size(); j++) {
                int diff = A.get(j) - A.get(i);
                int lookAheadNumber = A.get(j) + diff;
                int currentSubSeq = 2;

                for (int k = j + 1; k < A.size(); k++) {
                    if (A.get(k) == lookAheadNumber) {
                        currentSubSeq++;
                        lookAheadNumber += diff;
                    }
                }
                longestSubSeq = Math.max(longestSubSeq, currentSubSeq);
            }
        }
        return longestSubSeq;
    }

    public int minJump(ArrayList<Integer> A) {
        if (A == null || A.size() == 1) {
            return 0;
        }
        int maxReachIndex = A.get(0);
        int lastReachIndex = A.get(0);
        int jumps = 1;

        for (int i = 1; i < A.size(); i++) {
            if (maxReachIndex < i)
                return -1;

            if (lastReachIndex < i) {
                jumps++;
                lastReachIndex = maxReachIndex;
            }
            maxReachIndex = Math.max(maxReachIndex, i + A.get(i));
        }
        return jumps;
    }

    public int canJump(ArrayList<Integer> A) {
        if (A == null)
            return 1;
        int currJump = 0;
        for (int i = 0; i < A.size(); i++) {
            if (currJump < 0) return 0;
            currJump = Math.max(A.get(i), currJump);
            currJump--;
        }
        return 1;
    }

    //https://cs.stackexchange.com/questions/96984/find-the-lexicographically-smallest-order-of-n-numbers-such-that-the-total-of-n
    public ArrayList<Integer> TusharBirthdayBombs(int A, ArrayList<Integer> B) {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < B.size(); i++) {
            if (min > B.get(i)) {
                min = B.get(i);
                ind = i;
            }
        }
        int maxKicks = A / min;
        int temp = maxKicks;
        ArrayList<Integer> ansIndex = new ArrayList<>();
        if (maxKicks == 0) {
            return ansIndex;
        }
        for (int i = 0; i < maxKicks; i++) {
            ansIndex.add(ind);
        }
        int sum = maxKicks * B.get(ind);
        for (int i = 0; i < ind; i++) {
            if (sumDiff(ansIndex, B, A) == 0 || temp == 0) {
                Collections.sort(ansIndex);
                return ansIndex;
            }
            while ((sum - B.get(ind) + B.get(i)) <= A && temp != 0) {
                ansIndex.remove(0);
                ansIndex.add(i);
                temp--;
                sum += (B.get(i) - B.get(ind));
            }
        }
        Collections.sort(ansIndex);
        return ansIndex;
    }

    private int sumDiff(ArrayList<Integer> ans, ArrayList<Integer> B, int A) {
        int sum = 0;
        for (int i = 0; i < ans.size(); i++) {
            sum += B.get(ans.get(i));
        }
        return A - sum;
    }

    int chordCount(int A) {
        if (A == 0) {
            return 0;
        }
        int mod = 1000000000 + 7;
        //Ways(n) = sum[i = 0 to n-1] { Ways(i)*Ways(n-i-1) }
        long ways[] = new long[A + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= A; i++) {
            for (int j = 0; j <= i - 1; j++) {
                ways[i] += ways[j] * ways[i - j - 1];
                ways[i] %= mod;
            }
        }
        return (int) ways[A];
    }
    /*
         if (A == 0) {
            return 0;
        }
        int n = A * 2; //points
        int ways[] = new int[n + 1];
        ways[0] = 1;
        ways[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                ways[i] += ways[j] * ways[i - 2 - j];
            }
        }
        return ways[n];
     */

    int climbingStair(int A) {
        if (A == 0) {
            return 0;
        }
        int ways[] = new int[A + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= A; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[A];
    }

    int waysToDecode(String A) {
        if (A == null || A.length() == 0 || A.charAt(0) == '0')
            return 0;
        int decoded[] = new int[A.length()]; // better to create n+1 length array
        decoded[0] = 1;
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) != '0')
                decoded[i] = decoded[i - 1];
            int a = Integer.parseInt(A.substring(i - 1, i + 1));
            if (a >= 10 && a <= 26) {
                decoded[i] += i > 1 ? decoded[i - 2] : 1;
            }
            if (decoded[i] == 0) {
                return 0;
            }
        }
        return decoded[A.length() - 1];
    }

    int lengthOflongestIncreasingDecresingSequence(ArrayList<Integer> A) {
        if (A == null || A.size() == 0)
            return 0;

        int incr[] = new int[A.size()];
        int decr[] = new int[A.size()];
        int lastIndex = A.size() - 1;
        for (int i = 0; i < A.size(); i++) {
            incr[i] = 1;
            decr[lastIndex - i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(i).compareTo(A.get(j)) > 0)
                    incr[i] = Math.max(incr[i], incr[j] + 1);
            }

            for (int j = lastIndex - i + 1; j <= lastIndex; j++) {
                if (A.get(lastIndex - i).compareTo(A.get(j)) > 0)
                    decr[lastIndex - i] = Math.max(decr[lastIndex - i], decr[j] + 1);
            }
        }
//        System.out.println(Arrays.toString(incr));
//        System.out.println(Arrays.toString(decr));
        int maxLen = 1;
        for (int i = 0; i < A.size(); i++) {
            maxLen = Math.max(maxLen, incr[i] + decr[i] - 1);
        }
        return maxLen;
    }


}

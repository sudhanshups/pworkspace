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
        System.out.println(ibit.findSubsequenceCount("banana","ban"));

        System.out.println(ibit.InterleavingStrings("USfMSU", "5YgZ9N5mR6ppfggzbzh7HTox85MwFtaIQDHfzJW8vc2G", "5YgUSZf9NM5SmR6Uppfggzbzh7HTox84MwFtaIQDHfzJW8vc2G"));

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
                }else if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1) ){
                    //matching with last of A and last of B
                    dp[i][j] = dp[i - 1][j]||dp[i][j - 1];
                }
            }
        }
        return dp[m][n]?1:0;
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

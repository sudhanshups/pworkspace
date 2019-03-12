package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + "),";
    }
}

class ExtendedNum {
    int originalValue;
    long modifiedValue;

    public ExtendedNum(int originalValue, int n) {
        this.originalValue = originalValue;
        String s = Integer.toString(originalValue);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        while (ans.length() <= n + 1)
            ans.append(sb);

        s = ans.toString().substring(0, n + 1);
        modifiedValue = Long.parseLong(s);
    }

//    public String toString()
//    { return "[" + modifiedValue + ", " + originalValue + "]"; }
}

class MatrixMedian {
    int x;
    int i;
    int j;

    public MatrixMedian(int x, int i, int j) {
        this.x = x;
        this.i = i;
        this.j = j;
    }
}

class MatrixMedianComparator implements Comparator<MatrixMedian> {
    public int compare(MatrixMedian o1, MatrixMedian o2) {
        if (o1.x > o2.x)
            return 1;
        else if (o1.x < o2.x)
            return -1;
        return 0;
    }
}

public class CF473_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       /* String input = in.readLine();
        String pattern = in.readLine();*/

        /*int n = Integer.parseInt(in.readLine());
        List<Integer> query2 = Arrays.asList(1, 2, 3);
        List<Integer> query3 = new ArrayList<Integer>(){{add(1), add(2), add(3)}};

        ArrayList<ArrayList<Integer>> matrics = new ArrayList<>();
        matrics.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
        matrics.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        matrics.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));

        ArrayList<Integer> query = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        ArrayList<String> query1 = new ArrayList<>(Arrays.asList(""));
        int[] arr = new int[]{1,2}; */
/*
        LocalDateTime fromTime = LocalDateTime.now().plusMinutes(1);
        LocalDateTime toTime = LocalDateTime.now();
        if(fromTime.compareTo(toTime)<0){
            System.out.println("from time smaller than to time");
        }


        System.out.println(maxLen(new int[]{1, 0, 0, 1, 0, 1, 1}, 7));

        if ((1 & 1) == 1) {
            System.out.println(1 & 1);
        }

        String[] input = {
                "ABC",
                "AACECAAAA"
        };
        String[] pattern = {
                "^loworl^wh^",
                "he^ooworld",
                "he^w^whats^",
                "he^^orld^",
                "hel^worlda^hel"
        };

        //for (int i = 0; i < input.length; i++) {
        //System.out.println(flowerBouquets(3, 2, "00010001"));
        //}

        */

        //System.out.println( AmazingSubarrays("pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn"));
        ArrayList<String> a = new ArrayList<>();
        fullJustify(new ArrayList<>(Arrays.asList("lkgyyrqh", "qrdqusnh", "zyu", "w", "ukzxyykeh", "zmfqafqle", "e", "ajq", "kagjss", "mihiqla", "qekf", "ipxbpz", "opsndtyu", "x", "ec", "cbd", "zz", "yzgx", "qbzaffgf", "i", "atstkrdph", "jgx", "qiy", "jeythmm", "qgqvyz", "dfagnfpwat", "sigxajhjt", "zx", "hwmcgss" )),
                178).stream().forEach(u -> System.out.println(u + u.length()));

    }

    public static ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        List<List<String>> lines = new ArrayList<>();
        if (A.size() == 0)
            return new ArrayList<>();
        else if (A.size() == 1) {
            ArrayList<String> s = new ArrayList<>();
            String x = new String();
            for (int j = 0; j < B - A.get(0).length(); j++)
                x = x + " ";
            x = A.get(0) + x;
            s.add(x);
            return s;
        }

        List<Integer> spaces = new ArrayList<>();
        int l = 0;
        List<String> line = new ArrayList<>();
        for (String a : A) {
            if (l + line.size() + a.length() > B) {
                lines.add(line);
                spaces.add(B - l);
                l = 0;
                line = new ArrayList<>();
            }
            line.add(a);
            l += a.length();
        }
        lines.add(line);
        spaces.add(B - l);

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            List<String> oneLine = lines.get(i);
            int space = spaces.get(i);
            boolean last = false;
            if (i == lines.size() - 1)
                last = true;

            StringBuilder s = new StringBuilder();
            if (!last) {
                for (int k = 0; k < oneLine.size(); k++) {
                    int seg = ((oneLine.size() - 1 - k) == 0) ? space : (space / (oneLine.size() - 1 - k));
                    int r = (oneLine.size() - 1-k)==0 ?0 : (space % (oneLine.size() - 1-k));
                    if (r > 0)
                        seg++;

                    String a = oneLine.get(k);
                    s.append(a);
                    if (space < seg) {
                        for (int j = 0; j < space; j++)
                            s.append(" ");
                        space = 0;
                    } else {
                        for (int j = 0; j < seg; j++)
                            s.append(" ");
                        space = space - seg;
                    }
                    if (k >= 1 && k == oneLine.size() - 2) {
                        for (int j = 0; j < space; j++)
                            s.append(" ");
                        space = 0;
                    } else if (k == oneLine.size() - 1) {
                        for (int j = 0; j < space; j++)
                            s.append(" ");
                    }

                }
            } else {
                for (int k = 0; k < oneLine.size(); k++) {
                    String a = oneLine.get(k);
                    s.append(a);
                    if(space>0) {
                        s.append(" ");
                        space--;
                    }
                }
                for (int j = 0; j < space; j++)
                    s.append(" ");
            }
            res.add(s.toString());
        }

        return res;
    }

    public static int AmazingSubarrays(String a) {
        int mod = 10003;
        int no = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'a' || a.charAt(i) == 'A' ||
                    a.charAt(i) == 'e' || a.charAt(i) == 'E' ||
                    a.charAt(i) == 'i' || a.charAt(i) == 'I' ||
                    a.charAt(i) == 'o' || a.charAt(i) == 'O' ||
                    a.charAt(i) == 'u' || a.charAt(i) == 'U') {

                no = (no + (a.length() - i)) % mod;
            }
        }
        return no;

    }


    static int maxLen(int arr[], int n) {
        // max len of equal o and 1
        // maxLen(new int[]{1, 0, 0, 1, 0, 1, 1}, 7)
        // Creates an empty hashMap hM

        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];
            // To handle sum=0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }
            // If this sum is seen before, then update max_len
            // if required
            if (hM.containsKey(sum)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            } else // Else put this sum in hash table
                hM.put(sum + n, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);
        return max_len;
    }

    public static int flowerBouquets(int p, int q, String s) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i > 0)
                arr[i] = arr[i - 1];
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                int pre = i - 2 >= 0 ? arr[i - 2] : 0;
                arr[i] = (pre + q > arr[i - 1]) ? pre + q : arr[i - 1];
            }

            if (i > 1 && s.charAt(i) == '0' && s.charAt(i) == s.charAt(i - 1)
                    && s.charAt(i - 1) == s.charAt(i - 2)) {
                int pre = i - 3 >= 0 ? arr[i - 3] : 0;
                arr[i] = (pre + p > arr[i]) ? pre + p : arr[i];
            }
        }

        return arr[s.length() - 1];
    }


    public static int minCharToMakePalindrome(String input) {
        int cnt = 0;
        StringBuilder s = new StringBuilder(input);
        while (s.length() > 0) {
            if (isPolindrome(s.toString())) {
                break;
            } else {
                cnt++;
                s.deleteCharAt(s.length() - 1);
            }
        }
        return cnt;
    }

    public static boolean isPolindrome(String a) {
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1))
                return false;
        }
        return true;
    }

    public static Set<Integer> sieveOfEratosthenes(int n) {
        Set<Integer> primes = new HashSet<>();
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primes.add(i);
        }
        return primes;
    }


    public static String addBinary(String A, String B) {
        char c = '0';
        StringBuilder result = new StringBuilder();
        int al = A.length();
        int bl = B.length();
        int i = 0;
        for (i = 0; i < al && i < bl; i++) {
            if (A.charAt(al - 1 - i) == '1' && B.charAt(bl - 1 - i) == '1') {
                if (c == '1') {
                    result.append('1');
                } else {
                    result.append('0');
                    c = '1';
                }
            } else if (A.charAt(al - 1 - i) == '0' && B.charAt(bl - 1 - i) == '0') {
                if (c == '1') {
                    result.append('1');
                    c = '0';
                } else {
                    result.append('0');
                }
            } else {
                if (c == '1') {
                    result.append('0');
                    c = '1';
                } else {
                    result.append('1');
                    c = '0';
                }
            }
        }
        while (i < al) {
            if (A.charAt(al - i - 1) == '1' && c == '1') {
                result.append('0');
                c = '1';
            } else {
                if (c == '0')
                    result.append(A.charAt(al - i - 1));
                else
                    result.append('1');
                c = '0';
            }
            i++;
        }
        while (i < bl) {
            if (B.charAt(bl - i - 1) == '1' && c == '1') {
                result.append('0');
                c = '1';
            } else {
                if (c == '0')
                    result.append(B.charAt(bl - i - 1));
                else
                    result.append('1');
                c = '0';
            }
            i++;
        }
        if (c == '1')
            result.append('1');
        return result.reverse().toString();
    }

    public static String intToRoman(int number) {
        String[] m = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[number / 1000];
        String hundereds = c[(number % 1000) / 100];
        String tens = x[(number % 100) / 10];
        String ones = i[number % 10];

        String ans = thousands + hundereds + tens + ones;
        return ans;

    }

    public static int romanToInt(String number) {
        Map<Character, Integer> romanToNumber = new HashMap<>();
        romanToNumber.put('I', 1);
        romanToNumber.put('V', 5);
        romanToNumber.put('X', 10);
        romanToNumber.put('L', 50);
        romanToNumber.put('C', 100);
        romanToNumber.put('D', 500);
        romanToNumber.put('M', 1000);
        char last = '*';
        int result = 0;
        for (Character c : number.toCharArray()) {
            if (last == '*')
                last = c;
            else {
                if (romanToNumber.get(c) <= romanToNumber.get(last)) {
                    result += romanToNumber.get(last);
                    last = c;
                } else {
                    result += -romanToNumber.get(last) + romanToNumber.get(c);
                    last = '*';
                }
            }
        }
        if (last != '*')
            result += romanToNumber.get(last);

        return result;
    }


    public static String dedupe(String inputStr, int chunkSize) {
        //"aaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbcccccccccc",
        //                "uqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbn"
        int chunks = 0;
        StringBuilder dedup = new StringBuilder();
        for (int i = 0; i < inputStr.length(); ) {
            String str = inputStr.substring(i, i + chunkSize);
            if (dedup.indexOf(str) != -1) {
                int ind = dedup.indexOf(str);
                dedup.insert(dedup.indexOf(",", ind), "-" + chunks);
            } else {
                dedup.append(str + "-" + chunks + ",");
            }
            chunks++;
            i += chunkSize;
        }

        return dedup.toString();

    }

    public static String redupe(String inputStr, int chunkSize) {
        StringBuilder redup = new StringBuilder();

        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < inputStr.length(); ) {
            String str = inputStr.substring(i, i + chunkSize);
            int endOfChunk = inputStr.indexOf(",", i + chunkSize);

            String indexStr = inputStr.substring(i + chunkSize, endOfChunk);
            indexStr = indexStr.startsWith("-") ? indexStr.substring(1) : indexStr;
            String[] strIndex = indexStr.split("-");
            List<Integer> intIndex = Arrays.asList(strIndex).stream().map(Integer::parseInt).collect(Collectors.toList());
            intIndex.stream().forEach(u -> map.put(u, str));
            i = endOfChunk + 1;
        }
        map.entrySet().stream().forEach(u -> redup.append(u.getValue()));
        return redup.toString();
    }


    public static String unitedState(String input) {
        Pattern p = Pattern.compile("(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}");
        Matcher matcher = p.matcher(input);
        while (matcher.find()) {
            return matcher.group();
        }
        return "NONE";
    }

    public static String lookAndSay(int n) {
        StringBuilder seed = new StringBuilder("1");
        if (n == 1)
            return seed.toString();

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            char p = seed.charAt(0);
            int pCount = 1;
            for (int j = 1; j < seed.length(); j++) {
                if (seed.charAt(j) == p) {
                    pCount++;
                } else {
                    next.append(pCount);
                    next.append(p);
                    p = seed.charAt(j);
                    pCount = 1;
                }
            }
            next.append(pCount);
            next.append(p);
            seed = next;
        }
        return seed.toString();
    }

    public static String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder full = new StringBuilder();
        StringBuilder s = null;
        full.append(A.get(0));

        int i = 0;
        for (String s1 : A) {
            i++;
            String a = A.get(0);
            if (i <= 1)
                continue;

            s = new StringBuilder();
            for (int j = 0; j < a.length() && j < s1.length(); j++) {
                if (a.charAt(j) == s1.charAt(j)) {
                    s.append(a.charAt(j));
                }
            }
            if (full.length() > s.length())
                full = s;
        }
        return full.toString();
    }

    public static String reverse(String A) {
        StringBuilder full = new StringBuilder();
        StringBuilder s = new StringBuilder();
        for (Character c : A.toCharArray()) {
            if (c == ' ' && s.length() != 0) {
                if (full.length() != 0)
                    full.append(" ");
                full.append(s.reverse());
                s = new StringBuilder();
            } else {
                s.append(c);
            }
        }
        if (s.length() != 0) {
            if (full.length() != 0)
                full.append(" ");
            full.append(s.reverse());
        }
        return full.reverse().toString();
    }

    public static int lengthOfLastWord(final String A) {
        int l = 0;
        boolean spaceFound = false;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == ' ' && (i != A.length() - 1 && A.charAt(i + 1) != ' '))
                break;
            else if (A.charAt(i) != ' ')
                l++;
        }
        return l;
    }

    public static int palindrome(String a) {
        int end = a.length() - 1;
        for (int i = 0; i < end; ) {
            if (!Character.isLetterOrDigit(a.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(a.charAt(end))) {
                end--;
                continue;
            }

            if (Character.isLetter(a.charAt(i)) && Character.isLetter(a.charAt(end)) &&
                    Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(a.charAt(end))) {
                return 0;
            } else if (Character.isDigit(a.charAt(i)) && Character.isDigit(a.charAt(end)) &&
                    a.charAt(i) != a.charAt(end)) {
                return 0;
            }
            i++;
            end--;
        }
        return 1;
    }

    public static int findMinInRotatedArray(final List<Integer> a) {
        findMinInRotatedArray(a, 0, a.size() - 1);
        return 0;
    }

    public static int findMinInRotatedArray(final List<Integer> A, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end)
            return A.get(0);

        if (A.get(end) == A.get(start))
            return A.get(start);

        if (mid < end && A.get(mid) > A.get(mid + 1)) {
            return A.get(mid + 1);
        }

        if (mid > start && A.get(mid - 1) > A.get(mid))
            return A.get(mid);

        if (A.get(mid) < A.get(end))
            return findMinInRotatedArray(A, start, mid - 1);

        return findMinInRotatedArray(A, mid + 1, end);
    }

    public static int findInRotatedArray(final List<Integer> A, int start, int end, int u) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;

        if (A.get(mid) == u)
            return mid;

        if (A.get(start) <= A.get(mid)) {
            if (u >= A.get(start) && u <= A.get(mid))
                return findInRotatedArray(A, start, mid - 1, u);
            return findInRotatedArray(A, mid + 1, end, u);
        }

        if (u >= A.get(mid) && u <= A.get(end))
            return findInRotatedArray(A, mid + 1, end, u);
        return findInRotatedArray(A, start, mid - 1, u);
    }

    public static int searchInRotatedArray(final List<Integer> a, int b) {
        return findInRotatedArray(a, 0, a.size() - 1, b);

    }


    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        return new ArrayList(Arrays.asList(findFirst(a, 0, a.size() - 1, b),
                findLast(a, 0, a.size() - 1, b)));
    }

    public static int PainterPartition(int painter, int timePerUnit, ArrayList<Integer> partitions) {
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


    public static int findFloor(final List<Integer> A, int start, int end, int n, int u) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;

        if ((A.get(mid) == u && (mid == 0 || A.get(mid - 1) < u))) {// || (A.get(mid)<u && (mid<n-1 && A.get(mid+1)>u))){
            return mid;
        } else if (A.get(mid) < u && (mid == (n - 1) || A.get(mid + 1) > u)) {
            return mid + 1;
        } else if (A.get(mid) < u) {
            return findFloor(A, mid + 1, end, n, u);
        } else
            return findFloor(A, start, mid - 1, n, u);
    }

    public static int searchInsert(ArrayList<Integer> a, int b) {
        int index = findFloor(a, 0, a.size(), a.size(), b);
        if (index == -1)
            return 0;
        return index;
    }

    public static int sqrtBinary(int a, int l, int h) {
        long mid = l + (h - l) / 2;
        long sqr = mid * mid;
        if (sqr == a)
            return (int) mid;
        else if (((mid + 1) * (mid + 1) > a) && sqr < a)
            return (int) mid;
        else if (sqr > a)
            return sqrtBinary(a, l, (int) mid - 1);
        return sqrtBinary(a, (int) mid + 1, h);
    }

    public static int sqrt(int a) {
        if (a == 0)
            return 0;
        return sqrtBinary(a, 1, a);

    }

    public static int pow(int x, int n, int d) {
        //x^n%d
        if (x == 0)
            return 0;
        x = x % d;
        if (x < 0)
            x = x + d;

        long result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = (result * x) % d;
            }
            n = n >> 1;
            long a = x * x % d;
            x = (int) (((long) x % d * (long) x % d) % d);
        }
        return (int) result;
    }

    public static int findCeilRow(final ArrayList<ArrayList<Integer>> A, int start, int end, int u) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;

        if (A.get(mid).get(0) <= u && (mid + 1 == A.size() || A.get(mid + 1).get(0) > u))
            return mid;
        else if (A.get(mid).get(0) < u)
            return findCeilRow(A, mid + 1, end, u);
        else
            return findCeilRow(A, start, mid - 1, u);
    }

    public static int findInMatrics(ArrayList<ArrayList<Integer>> A, int x) {
        int r = findCeilRow(A, 0, A.size() - 1, x);
        if (r == -1)
            return 0;
        int c = findFirst(A.get(r), 0, A.get(r).size() - 1, x);
        if (c == -1)
            return 0;
        return 1;
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<MatrixMedian> priorityQueue = new PriorityQueue<>(new MatrixMedianComparator());
        int i;
        for (i = 0; i < A.size(); i++) {
            priorityQueue.add(new MatrixMedian(A.get(i).get(0), i, 0));
        }
        i = 1;
        while (!priorityQueue.isEmpty()) {
            MatrixMedian m = priorityQueue.poll();
            if (i == (A.size() * A.get(m.i).size() + 1) / 2)
                return m.x;
            if (m.j < A.get(m.i).size() - 1) {
                priorityQueue.add(new MatrixMedian(A.get(m.i).get(m.j + 1), m.i, m.j + 1));
            }
            i++;
        }
        return 0;
    }

    public static int findFirst(final List<Integer> A, int start, int end, int u) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;

        if (A.get(mid) == u && (mid == 0 || A.get(mid - 1) < u))
            return mid;
        else if (A.get(mid) < u)
            return findFirst(A, mid + 1, end, u);
        else
            return findFirst(A, start, mid - 1, u);
    }

    public static int findLast(final List<Integer> A, int start, int end, int u) {
        int mid = (start + end) / 2;
        if (start > end)
            return -1;

        if (A.get(mid) == u && (mid == A.size() - 1 || A.get(mid + 1) > u))
            return mid;
        else if (A.get(mid) <= u)
            return findLast(A, mid + 1, end, u);
        else
            return findLast(A, start, mid - 1, u);
    }

    public static int findCount(final List<Integer> A, int B) {
        int s = findFirst(A, 0, A.size() - 1, B);
        int e = findLast(A, 0, A.size() - 1, B);
        if (s != -1) {
            return e - s + 1;
        }
        return 0;
    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A * 2 - 1; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < A * 2 - 1 - i; j++) {
                int c = A - Math.min(i, j);
                a.add(c);
            }
            result.add(a);
        }
        for (int i = 0; i < A * 2 - 1; i++) {
            for (int j = A * 2 - 1 - i; j < A * 2 - 1; j++) {
                int c = i;
                if (i >= A)
                    c = A - i % A - 1;
//                int c = result.get(i);
                result.get(i).add(result.get(c - 1).get(j));
            }
        }

        return result;

    }

    public static int repeatedNumberNBy2(final List<Integer> a) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == first) {
                count1++;
            } else if (a.get(i) == second) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                first = a.get(i);
            } else if (count2 == 0) {
                count2++;
                second = a.get(i);
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if (first == a.get(i)) {
                count1++;
            } else if (second == a.get(i)) {
                count2++;
            }
        }
        if (count1 > a.size() / 3)
            return first;
        else if (count2 >= a.size() / 3)
            return second;

        return -1;
    }

    public static ArrayList<Integer> sieve(int A) {
        boolean[] arr = new boolean[A + 1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= A; i++) {
            if (arr[i] == false) {
                result.add(i);
                for (int j = i * 2; j <= A; j = j + i) {
                    arr[j] = true;
                }
            }
        }
        return result;
    }

    public static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    public static int findRank(String A) {
        // ZCSFLVHXRYJQKWABGT 318057 318057
        //DTNGJPURFHYEW  342501 342501
        int len = A.length();
        long mul = fact(len);
        long rank = 1;
        int countRight;

        for (int i = 0; i < len; ++i) {
            mul /= len - i;
            countRight = findSmallerInRight(A, i, len - 1);
            rank += countRight * mul;
            rank %= 1000003;

        }
        return (int) rank;
    }

    public static int gcd(int A, int B) {
        int x;
        while (B != 0) {
            x = A % B;
            A = B;
            B = x;
        }
        return A;
    }

    static int findSmallerInRight(String str, int low, int high) {
        int countRight = 0, i;
        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;
        return countRight;
    }

    public static long fact(long n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    public static int trailingZeroes(int A) {
        int c = 0;
        while (A != 0) {
            c += A / 5;
            A = A / 5;
        }
        return c;
    }

    public static int isPower(int A) {
        if (A == 1)
            return 1;
        for (int i = 2; i <= (int) Math.sqrt(A); i++) {
            float f = (float) Math.log(A) / (float) Math.log(i);
            if (Math.pow(i, (int) f) == A)
                return 1;
        }
        return 0;
    }

    public static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else
                result.add(Integer.toString(i));
        }
        return result;
    }

    public static int hammingDistance(final List<Integer> A) {
        long ans = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (Integer a : A) {
                if ((a & (1 << i)) == 0)
                    count++;
            }
            ans += count * (A.size() - count) * 2;
            ans = ans % 1000000007;
        }

        return (int) ans;
    }

    public static int reverse(int A) {
        boolean a = A < 0 ? true : false;
        int B = A < 0 ? -A : A;
        int r = 0, x;
        while (B != 0) {
            x = B % 10;
            if ((((r * 10 + x) - x) / 10) != r)
                return 0;
            r = r * 10 + x;
            B = B / 10;
//            if (r < 0)
//                return 0;
        }
        r = a ? r : -r;
//        if ((a && r < 0) || (!a && r >= 0))
//            return 0;
        return r;
    }

    public static String excelColumn(int n) {
        StringBuilder result = new StringBuilder();
        int a = 0, b = 0;
        while (n > 0) {
            a = n % 26;
            if (a == 0) {
                result.append('Z');
                n = n / 26 - 1;
            } else {
                result.append((char) ('A' + a - 1));
                n = n / 26;
            }
        }
        return result.reverse().toString();
    }

    public static int uniquePaths(int A, int B) {
        int[][] arr = new int[A + 1][B + 1];
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                if (i == 1 || j == 1)
                    arr[i][j] = 1;
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[A][B];
    }

    public static ArrayList<Integer> rearangeArray(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++)
            A.set(i, A.get(i) + (A.get(A.get(i)) % A.size()) * A.size());
        for (int i = 0; i < A.size(); i++)
            A.set(i, A.get(i) / A.size());

        return A;
    }

    public static int NumbersOfLengthNAndValueLessThanK(ArrayList<Integer> A, int B, int C) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            sum += getLessNumbers(A, num, B - 1, B, C);
        }

        return sum;
    }

    public static int getLessNumbers(ArrayList<Integer> A, int num, int len, int requiredLength, int requiredNum) {
        int sum = 0;
        if (len == 0) {
            if (num < requiredNum && Integer.toString(num).length() == requiredLength) {
                //System.out.println(num);
                return 1;
            } else return 0;
        }

        for (int i = 0; i < A.size(); i++) {
            int num1 = num * 10 + A.get(i);
            sum += getLessNumbers(A, num1, len - 1, requiredLength, requiredNum);
        }
        return sum;
    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i < A.size() * 2; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            result.add(row);
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                int r = i + j;
                result.get(r).add(A.get(i).get(j));
            }
        }

        return result;

    }


    public static boolean hotelBookingMaxRoom(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int c = 0;
        int start = 0;
        for (int i = 0; i < arrive.size(); i++) {
            while (depart.get(start) <= arrive.get(i) && start < i - 1)
                start++;

            if (i > 0 && depart.get(i - 1) <= arrive.get(i)) {
                start++;
            }
            c = Math.max(c, i - start + 1);

            //System.out.print(c);

        }

        if (c > K)
            return false;
        else
            return true;
    }

    public static int isPalindrome(int A) {
        if (A < 0)
            return 0;
        int reverse = 0;
        int original = A;
        while (original != 0) {
            reverse = reverse * 10 + original % 10;
            original /= 10;
        }
        if (reverse == A)
            return 1;
        else return 0;
    }

    public static int titleToNumber(String A) {
        int base = 26;
        int index = 0;
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            result = result * 26 + A.charAt(i) - ('A') + 1;
        }

        return result;
    }

    public static ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C, ArrayList<Integer> D) {
        Collections.sort(C);
        int commulativeOnces[] = new int[C.size()];
        for (int i = 0; i < C.size(); i++) {
            if (i == 0)
                commulativeOnces[i] = countSetBits(C.get(i));
            else
                commulativeOnces[i] = countSetBits(C.get(i)) + commulativeOnces[i - 1];
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int k = 0; k < D.size(); k++) {
            int i = 0, j = commulativeOnces.length - 1;
            int minLength = Integer.MAX_VALUE;
            minLength = minLength(i, j, commulativeOnces, D.get(k), minLength);

            if (minLength == Integer.MAX_VALUE)
                result.add(-1);
            else
                result.add(minLength);
        }

        return result;
    }

    static int minLength(int i, int j, int commulativeOnces[], int KVal, int minLength) {
        if (i > j)
            return Integer.MAX_VALUE;
        if (i == 0) {
            if ((commulativeOnces[j]) >= KVal && minLength > commulativeOnces[j]) {
                minLength = j + 1;
            }
        } else {
            if ((commulativeOnces[j] - commulativeOnces[i]) >= KVal && minLength >= (commulativeOnces[j] - commulativeOnces[i])) {
                minLength = j - i + 1;
            }
        }
        if (commulativeOnces[j] > KVal) {
            minLength = Math.min(minLength(i, j - 1, commulativeOnces, KVal, minLength), minLength);
        } else
            minLength = Math.min(minLength(i + 1, j, commulativeOnces, KVal, minLength), minLength);
        return minLength;
    }

    static int countSetBits(int n) {
        if (n == 0)
            return 0;
        else
            return (n & 1) + countSetBits(n >> 1);
    }


    public static ArrayList<Integer> KthRowPascalTrianle(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int i, j;
        result.add(1);
        for (i = 1; i <= n; i++) {
            result.add(1);
            for (j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }

    public static int maxDistance(ArrayList<Integer> A) {
        int lMin[] = new int[A.size()];
        int rMax[] = new int[A.size()];
        int i, j;

        for (i = 0; i < A.size(); i++) {
            if (i == 0)
                lMin[i] = A.get(i);
            else {
                lMin[i] = Math.min(lMin[i - 1], A.get(i));
            }
        }
        for (j = A.size() - 1; j >= 0; j--) {
            if (j == A.size() - 1)
                rMax[j] = A.get(j);
            else {
                rMax[j] = Math.max(rMax[j + 1], A.get(j));
            }
        }
        i = 0;
        j = 0;
        int max = Integer.MIN_VALUE;
        while (i < A.size() && j < A.size()) {
            if (lMin[i] <= rMax[j]) {
                max = Math.max(max, j - i);
                j++;
            } else
                i++;
        }
        return max;
    }

    public static ArrayList<Interval> mergeOverlappingInterval(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> (o1.start - o2.start));
        ArrayList<Interval> result = new ArrayList<>();

        Stack<Interval> stack = new Stack<>();

        stack.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval top = stack.peek();
            if (top.end < intervals.get(i).start) {
                stack.push(intervals.get(i));
            } else if (top.end < intervals.get(i).end) {
                stack.pop();
                top.end = intervals.get(i).end;
                stack.push(top);

            }
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> pascalTrianle(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i, j;
        for (i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if (i == 0)
                row.add(1);
            else {
                for (j = 0; j <= i; j++) {
                    if (j == 0 || j == i)
                        row.add(1);
                    else
                        row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(row);
        }
        return result;
    }

    public static ArrayList<Integer> findArrayToPartialSorted(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int eIndex = -1;
        int sIndex = -1;
        int i;
        for (i = 1; i < A.size(); i++) {
            if (A.get(i) < A.get(i - 1)) {
                sIndex = i - 1;
                break;
            }
        }
        for (i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                eIndex = i + 1;
                break;
            }
        }

        if (sIndex == -1) {
            result.add(-1);
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (i = sIndex; i <= eIndex; i++) {
            if (A.get(i) > max)
                max = A.get(i);
            if (A.get(i) < min)
                min = A.get(i);
        }

        // get the min index
        for (i = 0; i < sIndex; i++) {
            if (A.get(i) > min) {
                sIndex = i;
                break;
            }
        }
        // get the max index
        for (i = A.size() - 1; i > eIndex; i--) {
            if (A.get(i) < max) {
                eIndex = i;
                break;
            }
        }
        result.add(sIndex);
        result.add(eIndex);
        return result;
    }


    public static ArrayList<ArrayList<Integer>> generateSpiralOrderMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                row.add(0);
            }
            result.add(row);
        }
        int i = 0, j = 0, k, l;
        int m = result.size();  //row
        int n = result.get(0).size(); //col
        int x = 1;
        while (i < m && j < n) {
            for (k = j; k < n; k++) {
                result.get(i).set(k, x);
                x++;
            }
            i++;
            for (k = i; k < m; k++) {
                result.get(k).set(n - 1, x);
                x++;
            }
            n--;
            if (i < m) {
                for (k = n - 1; k >= j; k--) {
                    result.get(m - 1).set(k, x);
                    x++;
                }
                m--;
            }
            if (j < n) {
                for (k = m - 1; k >= i; k--) {
                    result.get(k).set(j, x);
                    x++;
                }
                j++;
            }
        }

        return result;
    }


    public static ArrayList<Integer> spiralOrderMatrix(final List<ArrayList<Integer>> A) {
        int i = 0, j = 0, k, l;
        int m = A.size();  //row
        int n = A.get(0).size(); //col
        ArrayList<Integer> result = new ArrayList<>();
        while (i < m && j < n) {
            for (k = j; k < n; k++) {
                result.add(A.get(i).get(k));
            }
            i++;
            for (k = i; k < m; k++) {
                result.add(A.get(k).get(n - 1));
            }
            n--;
            if (i < m) {
                for (k = n - 1; k >= j; k--) {
                    result.add(A.get(m - 1).get(k));
                }
                m--;
            }
            if (j < n) {
                for (k = m - 1; k >= i; k--) {
                    result.add(A.get(k).get(j));
                }
                j++;
            }
        }

        return result;
    }

    public static int repeatedNumber(final List<Integer> a) {

        int[] arr = new int[a.size()];

        List<Integer> result = new ArrayList<>();
        result.addAll(a);
        //result.add(a.size());
        for (int i = 0; i < result.size(); i++) {
            if (result.get(Math.abs(result.get(i)) - 1) < 0)
                return Math.abs(result.get(i));
            result.set(Math.abs(result.get(i)) - 1, -result.get(Math.abs(result.get(i)) - 1));
        }
        return -1;
    }


    public static int tripletsWithSumBetweenGivenRange() {

        return 0;
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {
        /*
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,4,2,3));
        //7, 5, 7, 9, 8, 7));
        //5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));
        //6, 7, 9, 5, 5, 8));
        //5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));
        //4,2,3,4));
        //3,4,-1,1));
        //1,2,0));
         */
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        left.add(0);
        for (int i = 1; i < A.size(); i++) {
            while (!stack.empty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }
            if (stack.empty()) {
                left.add(0);
            } else {
                left.add(stack.peek());
            }
            stack.push(i);
        }
        stack = new Stack<>();
        stack.push(A.size() - 1);
        right.add(0);
        for (int i = A.size() - 2; i >= 0; i--) {
            while (!stack.empty() && A.get(stack.peek()) <= A.get(i))
                stack.pop();
            if (stack.empty()) {
                right.add(0);
            } else {
                right.add(stack.peek());
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            long c = ((long) left.get(i) * (long) right.get(right.size() - 1 - i)) % 1000000007;
            int t = (int) c;
            if (t > max)
                max = t;
        }
        return max;
    }


    public static String largestNumber(final List<Integer> A) {

        int n = Collections.max(A).toString().length();
        ArrayList<ExtendedNum> en = new ArrayList<>();
        for (int i = 0; i < A.size(); i++)
            en.add(new ExtendedNum(A.get(i), n));

        // sort based on modified value
        Collections.sort(en, (p1, p2) -> (int) (p2.modifiedValue - p1.modifiedValue));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < en.size(); i++)
            sb.append(new StringBuilder(Integer.toString(en.get(i).originalValue)));

        // To remove any zeroes at head.
        BigInteger bi = new BigInteger(sb.toString());

        return bi.toString();

    }

    public static ArrayList<Integer> repeatedAndMissingNumber(final List<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(A);
        int repeated = 0;
        int missing = 0;
        for (int i = 0; i < temp.size(); i++) {
            int numAtindex = temp.get(Math.abs(temp.get(i)) - 1);
            if (numAtindex < 0) {
                repeated = Math.abs(temp.get(i));
            }

            if (numAtindex > 0)
                temp.set(Math.abs(temp.get(i)) - 1, -numAtindex);
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) > 0) {
                missing = i + 1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeated);
        result.add(missing);
        return result;
    }

    public static int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int p = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= 0)
                continue;
            else if ((p + 1) != A.get(i)) {
                return p + 1;
            }
            p = A.get(i);
        }
        return p + 1;

    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(A);
        int l = A.size();
        for (int i = 0; i < l; i = i + 2) {
            if (i + 1 < l)
                result.add(A.get(i + 1));
            result.add(A.get(i));
        }
        return result;
    }

    /**
     * ArrayList<Interval> a = new ArrayList<>();
     * a.add(new Interval(3, 5));
     * a.add(new Interval(7, 9));
     * ArrayList<Interval> output = mergeInterval(a, new Interval(6, 7));
     * for (int i = 0; i < output.size(); i++)
     * System.out.print(output.get(i) + " ");
     */
    public static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals, Interval newInterval) {

        Collections.sort(intervals, (o1, o2) -> (o1.start - o2.start));
        ArrayList<Interval> result = new ArrayList<>();
        int j = 0;
        boolean merged = false;

        for (int i = 0; i < intervals.size(); i++) {
            boolean m = false;
            if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start
                    && !(intervals.get(i).start == newInterval.start && intervals.get(i).end == newInterval.end)) {
                newInterval.start = intervals.get(i).start;
                m = true;
            }
            if (intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end
                    && !(intervals.get(i).start == newInterval.start && intervals.get(i).end == newInterval.end)) {
                newInterval.end = intervals.get(i).end;
                m = true;
            }
            if (!merged && m) {
                merged = true;
                result.add(newInterval);
            } else if (intervals.get(i).start > newInterval.end || intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
            }
        }
        if (!merged)
            result.add(newInterval);
        Collections.sort(result, (o1, o2) -> (o1.start - o2.start));


        return result;
    }

}

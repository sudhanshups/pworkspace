package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class InterviewbitHashing {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitHashing ibit = new InterviewbitHashing();

        //    System.out.println(ibit.colorful(23));

        /*ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 0, 0, -2, 4, 4));
        System.out.println(ibit.lszero(numbers));*/

    /*    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 2, 7, 11, 11, 15));
        System.out.println(ibit.twoSum(numbers, 13));*/

    /*    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2));
        System.out.println(ibit.fourSum(numbers, 0));*/

        /*List<String> numbers = new ArrayList<>(Arrays.asList("....5..1.", ".4.3.....", ".....3..1",
                "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"));
//                "53..7....", "6..195...", ".98....6.", "8...6...3",
//                "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"));
        for (int j = 0; j < 9; j++) {
            System.out.print(j + " |");
        }
        System.out.println();
        for (String s : numbers) {
            for (int j = 0; j < 9; j++) {
                System.out.print(s.charAt(j) + " |");
            }
            System.out.println();
        }
        System.out.println(ibit.isValidSudoku(numbers));*/

/*        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13));
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(j) - numbers.get(i) == 60) {
                    System.out.println(numbers.get(i) + " " + numbers.get(j));
                }
            }
        }
        System.out.println(ibit.diffPossible(numbers, 60));*/

/*        ArrayList<String> input = new ArrayList<>(Arrays.asList("cat", "dog", "god", "tca"));
        System.out.println(ibit.anagrams(input));*/

/*        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        System.out.println(ibit.fourSumEqualls(input));*/

        /*RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = null;

        ibit.printList(head);

        System.out.println("-----");

        RandomListNode copy  = ibit.copyRandomList(head);
        ibit.printList(copy);
        System.out.println();*/

        //System.out.println(ibit.lengthOfLongestSubstring("ababc"));

    /*    System.out.println(ibit.minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh",
                "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));*/

        System.out.println(ibit.fraction(-1, -2147483648));

    }

    public String fraction(int A, int B) {
        boolean isNeg = (A <= 0 && B > 0) || (A >= 0 && B < 0) ? true : false;
        long a = Math.abs(A * 1l);
        long b = Math.abs(B * 1l);

        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();

        if (a == 0)
            return "0";

        if (b > a) {
            pre.append("0.");
        } else if (b == a) {
            pre.append("1");
            a -= b;
        } else {
            pre.append(a / b);
            a = a % b;
            if (a > 0) {
                pre.append(".");
            }
        }
        long d = 0;
        Set<String> set = new HashSet<>();


        while (a < b) {
            a = a * 10;
            post.append("0");

        }
        while (a != 0) {
            a = a * 10;
            d = a / b;
            a %= b;

            if (set.contains(Long.toString(d))) {
                String portS = post.toString();
                String nonRep = portS.substring(0, portS.indexOf(Long.toString(d)));
                String repe = portS.substring(portS.indexOf(Long.toString(d)), portS.length());
                post = new StringBuilder();
                post.append(nonRep);
                if (repe.length() > 0) {
                    post.append("(" + repe + ")");
                }
                break;
            }
            post.append(d);
            set.add(Long.toString(d));
            //set.add(post.toString());

        }

        if (isNeg)
            return "-" + pre.append(post).toString();
        else
            return pre.append(post).toString();
    }


    public String minWindow(String A, String B) {

        int patMap[] = new int[256];
        int stringMap[] = new int[256];

        for (char c : B.toCharArray()) {
            patMap[c]++;
        }

        int count = 0;

        int start = 0;
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < A.length(); i++) {

            stringMap[A.charAt(i)]++;

            if (patMap[A.charAt(i)] != 0 && stringMap[A.charAt(i)] <= patMap[A.charAt(i)])
                count++;

            if (count == B.length()) {
                while (stringMap[A.charAt(start)] > patMap[A.charAt(start)] || patMap[A.charAt(start)] == 0) {
                    if (stringMap[A.charAt(start)] > patMap[A.charAt(start)]) {
                        stringMap[A.charAt(start)]--;
                    }
                    start++;
                }

                if (minLength > i - start + 1) {
                    startIndex = start;
                    minLength = i - start + 1;
                    found = true;
                }
            }
        }

        if (!found)
            return "";

        return A.substring(startIndex, startIndex + minLength);
    }


    public int lengthOfLongestSubstring(String A) {
        /*Another approach without queue
        HashSet<Character> hashSet = new HashSet<Character>();
        int maxCount = 0;
        int start = 0;
        for(char c : A.toCharArray()){
            while(hashSet.contains(c)){
                hashSet.remove(A.charAt(start));
                start++;
            }
            hashSet.add(c);
            maxCount = Math.max(maxCount, hashSet.size());
        }

        return maxCount;
         */

        Queue<Integer> queue = new LinkedList<>();
        Map<Character, Integer> charToIndex = new HashMap<>();
        int l = 0;
        int start = 0;
        for (int i = 0; i < A.length(); i++) {
            if (charToIndex.containsKey(A.charAt(i))) {
                while (!queue.isEmpty() && queue.peek() <= charToIndex.get(A.charAt(i))) {
                    queue.poll();
                }
            }
            charToIndex.put(A.charAt(i), i);
            queue.add(i);
            if (l < queue.size()) {
                l = queue.size();
                start = queue.peek();
            }
        }

        return l;
    }


    private void printList(RandomListNode head1) {
        while (head1 != null) {
            System.out.print(head1.label);
            if (head1.next != null)
                System.out.print("  -> " + head1.next.label);
            if (head1.random != null)
                System.out.print("  ->* " + head1.random.label);
            System.out.println();
            head1 = head1.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode original = head;
        RandomListNode preOriginal = null;
        RandomListNode copyHead = null;
        RandomListNode copyCurrent;
        RandomListNode copyPre = null;

        while (original != null) {
            copyCurrent = new RandomListNode(original.label);
            copyCurrent.random = original;

            if (copyHead == null) {
                copyHead = copyCurrent;
            } else {
                preOriginal.next = copyPre;
                copyPre.next = copyCurrent;
            }
            preOriginal = original;
            copyPre = copyCurrent;
            original = original.next;
        }
        preOriginal.next = copyPre;

        copyCurrent = copyHead;

        while (copyCurrent != null) {
            if (copyCurrent.random.random == null)
                copyCurrent.random = null;
            else {
                copyCurrent.random = copyCurrent.random.random.next;
            }
            copyCurrent = copyCurrent.next;
        }

        return copyHead;
    }

    public ArrayList<Integer> fourSumEqualls(ArrayList<Integer> A) {
        ArrayList<TwoNum> arr = new ArrayList<>();
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                arr.add(new TwoNum(i, j, A.get(i) + A.get(j)));
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<TwoNum>> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            if (!map.containsKey(arr.get(i).sum)) {
                map.put(arr.get(i).sum, new ArrayList<>());
            }
            List<TwoNum> twoNums = map.get(arr.get(i).sum);
            for (TwoNum twoNum : twoNums) {
                if (nocommon(twoNum, arr.get(i))) {
                    ArrayList<Integer> res1 = new ArrayList<>();
                    if (arr.get(i).first < twoNum.first) {
                        res1.add(arr.get(i).first);
                        res1.add(arr.get(i).second);
                        res1.add(twoNum.first);
                        res1.add(twoNum.second);
                    } else {
                        res1.add(twoNum.first);
                        res1.add(twoNum.second);
                        res1.add(arr.get(i).first);
                        res1.add(arr.get(i).second);
                    }
                    res.add(res1);
                    res.sort((u, v) -> {
                        for (int it = 0; it < Math.min(u.size(), v.size()); it++) {
                            int c = u.get(it).compareTo(v.get(it));
                            if (c != 0) {
                                return c;
                            }
                        }
                        return 0;
                    });
                    ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
                    res2.add(res.get(0));
                    res = res2;
                }
            }
            map.get(arr.get(i).sum).add(arr.get(i));
        }

        return res.get(0);
    }

    private class TwoNum {
        int first;
        int second;
        int sum;

        TwoNum(int a, int b, int c) {
            first = a;
            second = b;
            sum = c;
        }
    }

    private boolean nocommon(TwoNum a, TwoNum b) {
        if (a.first == b.first || a.first == b.second || a.second == b.first || a.second == b.second) {
            return false;
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> anagramHAsh = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            char[] word = A.get(i).toCharArray();
            Arrays.sort(word);
            String str = new String(word);
            if (!anagramHAsh.containsKey(str)) {
                anagramHAsh.put(str, new ArrayList<>());
            }
            anagramHAsh.get(str).add(i + 1);
        }
        return new ArrayList<>(anagramHAsh.values());
    }

    public int diffPossible(final List<Integer> A, int B) {
        Set<Integer> s = new HashSet<>();
        for (int a : A) {
            if (s.contains(B + a) || s.contains(-B + a)) {
                return 1;
            }
            s.add(a);
        }

        return 0;
    }

    public int isValidSudoku(final List<String> A) {

        //row check
        for (int i = 0; i < A.size(); i++) {
            String row = A.get(i);
            Set<Character> s = new HashSet<>();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    continue;
                }
                if (s.contains(row.charAt(j))) {
                    return 0;
                }
                s.add(row.charAt(j));
            }
        }

        //col check
        for (int i = 0; i < A.size(); i++) {
            Set<Character> s = new HashSet<>();
            for (int j = 0; j < A.size(); j++) {
                if (A.get(j).charAt(i) == '.') {
                    continue;
                }
                if (s.contains(A.get(j).charAt(i))) {
                    return 0;
                }
                s.add(A.get(j).charAt(i));
            }
        }
        //block check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> s = new HashSet<>();
                for (int r = i * 3; r < i * 3 + 3; r++) {
                    for (int c = j * 3; c < j * 3 + 3; c++) {
                        if (A.get(r).charAt(c) == '.') {
                            continue;
                        }

                        if (s.contains(A.get(r).charAt(c))) {
                            return 0;
                        }
                        s.add(A.get(r).charAt(c));
                    }
                }
            }
        }
        return 1;
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        A.sort(Comparator.comparingInt(u -> u));
        for (int i = 0; i < A.size() - 3; ) {
            for (int j = i + 1; j < A.size() - 2; ) {
                int sum = A.get(i) + A.get(j);
                int l = j + 1;
                int h = A.size() - 1;
                while (l < h) {
                    int totalSum = sum + A.get(l) + A.get(h);
                    if (B == totalSum) {
                        ArrayList<Integer> res1 = new ArrayList<>();
                        res1.add(A.get(i));
                        res1.add(A.get(j));
                        res1.add(A.get(l));
                        res1.add(A.get(h));
                        res.add(res1);

                        l++;
                        h--;
                        while (l < A.size() && A.get(l - 1).equals(A.get(l))) {
                            l++;
                        }
                        while (h >= 0 && A.get(h + 1).equals(A.get(h))) {
                            h--;
                        }
                    } else if (totalSum > B) {
                        h--;
                    } else {
                        l++;
                    }
                }
                j++;
                if (j < A.size() && A.get(j - 1).equals(A.get(j))) {
                    while (j < A.size() && A.get(j - 1).equals(A.get(j))) {
                        j++;
                    }
                }
            }
            i++;
            if (i < A.size() && A.get(i - 1).equals(A.get(i))) {
                while (i < A.size() && A.get(i - 1).equals(A.get(i))) {
                    i++;
                }
            }
        }
        return res;
    }


    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer, List<Integer>> integerToIndex = new HashMap<>();
        int s = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < A.size(); i++) {
            if (integerToIndex.containsKey(B - A.get(i))) {
                List<Integer> indexes = integerToIndex.get(B - A.get(i));
                e = i;
                s = indexes.get(0);
                found = true;
                break;
            }
            if (!integerToIndex.containsKey(A.get(i))) {
                integerToIndex.put(A.get(i), new ArrayList<>());
            }
            integerToIndex.get(A.get(i)).add(i);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (found) {
            res.add(s + 1);
            res.add(e + 1);
        }
        return res;

    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int l = 0;
        int start = -1;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (A.get(i) == 0 && l == 0) {
                start = i;
                l = 1;
            }

            if (sum == 0) {
                l = i + 1;
                start = 0;
            }

            Integer prev_i = map.get(sum);

            if (prev_i != null) {
                if (l < i - prev_i) {
                    l = i - prev_i;
                    start = prev_i + 1;
                }
            } else  // Else put this sum in hash table
                map.put(sum, i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        if (start != -1) {
            for (int i = start; i < start + l; i++) {
                res.add(A.get(i));
            }
        }
        return res;
    }

    public int colorful(int A) {
        char[] charArray = new Integer(A).toString().toCharArray();
        HashMap<Long, Boolean> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            long product = 1;
            for (int j = i; j < charArray.length; j++) {
                product *= (charArray[j] - '0');
                if (map.containsKey(product)) {
                    return 0;
                }
                map.put(product, true);
            }
        }
        return 1;

    }
}

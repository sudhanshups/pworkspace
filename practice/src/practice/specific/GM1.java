package practice.specific;

import java.io.IOException;
import java.util.*;

public class GM1 {

    static String findQualifiedNumbers(int[] numberArray) {
        List<Integer> numbers = new ArrayList<>();
        for (int a : numberArray) {
            boolean one = false;
            boolean two = false;
            boolean three = false;
            long num = (a < 0) ? -(long) a : a;
            while (num != 0) {
                long r = num % 10;
                num = num / 10;
                if (r == 1) {
                    one = true;
                } else if (r == 2) {
                    two = true;
                } else if (r == 3) {
                    three = true;
                }
            }
            if (one && two && three) {
                numbers.add(a);
            }
        }
        if (numbers.isEmpty()) {
            return "-1";
        }
        Collections.sort(numbers);
        List<String> numberString = new ArrayList<>();
        for (long a : numbers) {
            numberString.add(String.valueOf(a));
        }
        return String.join(",", numberString);

    }

    static String findQualifiedNumbers1(int[] a) {
        List<Integer> ans = Arrays.stream(a).filter(x -> containsAll(x)).boxed().collect(java.util.stream.Collectors.toList());
        String z = ans.stream().sorted().map(String::valueOf).collect(java.util.stream.Collectors.joining(","));
        if (z.isEmpty()) return "-1";
        return z;
    }

    private static boolean containsAll(int x) {
        String s = String.valueOf(x);
        return s.contains("1") && s.contains("2") && s.contains("3");
    }

    public static long calculatePossibleCombinations1(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            ;
        }
        return dp[s.length() - 1];
    }

    //2nd ==
    public static long calculatePossibleCombinations(String s) {
//if(s.contains("00")) return 0;
        long ans = 0;
        long dp[] = new long[s.length()];
        Arrays.fill(dp, -1);
        ans = calculate(0, s, dp);
        return ans;
    }

    private static long calculate(int i, String s, long dp[]) {
        if (i == s.length() - 1 && s.charAt(i) != '0') return 1;
        if (i >= s.length()) return 1;
        if (dp[i] != -1) return dp[i];

        if (s.charAt(i) == '0') return 0;

        long ans1 = 0, ans2 = 0;

        if (i + 1 < s.length() && s.charAt(i + 1) == '0') {
            //only case is combine
            if (canTwoCharactersBeCombined(i, s)) {
                ans2 = calculate(i + 2, s, dp);
            }
        } else {
            ans1 = calculate(i + 1, s, dp);
            if (canTwoCharactersBeCombined(i, s)) {
                ans2 = calculate(i + 2, s, dp);
            }
        }
        return dp[i] = ans1 + ans2;
    }

    private static boolean canTwoCharactersBeCombined(int i, String s) {
        if (i + 1 >= s.length()) return false;
        if (s.charAt(i) == '0') return false;
        int x = Integer.parseInt(String.valueOf(s.charAt(i) + "" + s.charAt(i + 1)));
        //since on combine two digit is formed
        return (x >= 10 && x <= 26);
    }


    //==


    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MIN_VALUE);
        int[] arr = new int[]{100, 123, 1432, 0, 123, -123, Integer.MIN_VALUE, Integer.MAX_VALUE};
        System.out.println(findQualifiedNumbers(arr));


        System.out.println(calculatePossibleCombinations("2122"));
        System.out.println(calculatePossibleCombinations("2101"));

        System.out.println(calculatePossibleCombinations1("2122"));
        System.out.println(calculatePossibleCombinations1("2101"));
    }


}

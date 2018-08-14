package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class patternMatch {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        String pattern = in.readLine();

        Set<Integer> primes = sieveOfEratosthenes(10000);
        System.out.println(patternMatch(primes, input, 0, input.length() - 1,
                pattern, 0, pattern.length() - 1, 0) ? 1 : 0);

//        String[] input = {
//                "helloworlldwhatsup",
//                "helloworld",
//                "helloworldwhatsup",
//                "helloworldwhatsup",
//                "helloworldahahahel"
//        };
//        String[] pattern = {
//                "^loworl^wh^",
//                "he^ooworld",
//                "he^w^whats^",
//                "he^^orld^",
//                "hel^worlda^hel"
//        };

//        for (int i = 0; i < input.length; i++) {
//            System.out.println(patternMatch(primes, input[i], 0, input[i].length() - 1,
//                    pattern[i], 0, pattern[i].length() - 1, 0) ? 1 : 0);
//        }

    }

    public static boolean patternMatch(Set<Integer> primes, String input, int i, int n, String pattern, int j, int m, int l) {
        // If we reach at the end of both strings, we are done
        if (i == n && j == m) {
            if (primes.contains(l))
                return true;
            else return false;

        }
        if (pattern.charAt(j) == '^' && j + 1 != m && i == n)
            return false;

        if (i <= n && j <= m && input.charAt(i) == pattern.charAt(j))
            return patternMatch(primes, input, i + 1, n, pattern, j + 1, m, l + 1);

        if (j <= m && pattern.charAt(j) == '^')
            return patternMatch(primes, input, i + 1, n, pattern, j, m, l + 1)
                    || patternMatch(primes, input, i, n, pattern, j + 1, m, l + 1);
        return false;
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
}
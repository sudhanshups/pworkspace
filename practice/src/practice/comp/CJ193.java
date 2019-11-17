package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class Solution{
public class CJ193 {
    static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primes.add(i);
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        List<Integer> primes = sieveOfEratosthenes(10000);

        PriorityQueue<Integer > queue = new PriorityQueue<>();

        for (int k = 1; k <= t; k++) {
            String[] inputs = in.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int L = Integer.parseInt(inputs[1]);

            Set<Long> choosedPrimes = new TreeSet<>();
            long[] multiplications = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            // find first 2 primes
            long f = 1, s = 1;
            for (int p : primes) {
                if (multiplications[0] % p == 0) {
                    f = p;
                    s = multiplications[0] / p;
                    break;
                }
            }

            choosedPrimes.add(f);
            choosedPrimes.add(s);
            for (int i = 1; i < L; i++) {
                s = multiplications[i] / s;
                choosedPrimes.add(s);
            }
            Map<Long, Character> map = new HashMap<>();
            char a = 'A';
            for (Long i : choosedPrimes) {
                map.put(i, a);
                a = (char) ((int) a + 1);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(map.get(f));
            s = multiplications[0] / f;
            sb.append(map.get(s));

            for (int i = 1; i < L; i++) {
                s = multiplications[i] / s;
                sb.append(map.get(s));
            }

            System.out.println("Case #" + k + ": " + sb);
        }

    }
}

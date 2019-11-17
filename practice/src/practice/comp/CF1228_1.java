package practice.comp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1228_1 {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        int beg = l;
        Map<Integer, Integer> map = new HashMap<>();
        boolean duplicate = false;
        while (beg != 0) {
            int rem = beg % 10;
            beg /= 10;
            if (!map.containsKey(rem)) {
                map.put(rem, 0);
            }
            map.put(rem, map.get(rem) + 1);
            if (map.get(rem) > 1) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            System.out.println(l);
            return;
        }

        beg = l;
        StringBuilder x = new StringBuilder();
        int c = 0;
        while (beg != 0) {
            int rem = (beg % 10);
            beg /= 10;
            if (map.containsKey(rem) && map.get(rem) > 1) {
                for (int i = 1; i < 10; i++) {
                    int nrem = rem + i;
                    if (map.containsKey(nrem % 10)) {
                        continue;
                    }
                    c = nrem / 10;
                    map.put(beg % 10, map.get(beg % 10) - 1);

                    beg += c;
                    nrem = nrem % 10;
                    x.append(nrem);

                    if (!map.containsKey(nrem)) {
                        map.put(nrem, 0);
                    }
                    map.put(nrem, map.get(nrem) + 1);


                    map.put(rem, map.get(rem) - 1);
                    if (!map.containsKey(beg % 10)) {
                        map.put(beg % 10, 0);
                    }
                    map.put(beg % 10, map.get(beg % 10) + 1);
                    break;
                }
            } else {
                x.append(rem);
            }
        }
        int xn = Integer.parseInt(x.reverse().toString());
        if (xn > r || xn < l) {
            System.out.println("-1");
        } else {
            System.out.println(xn);
        }
/*
98766
100000

 */

    }
}
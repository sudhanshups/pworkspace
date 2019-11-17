package practice;

import lombok.extern.log4j.Log4j;

import java.util.*;

@Log4j
public class uniqueSubstringSizeK {

    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo = 0;
        int hi = 0;
        while (lo <= hi && hi < s.length()) {
            ch[s.charAt(hi) - 'a']++;
            while (ch[s.charAt(hi) - 'a'] != 1) {
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            if (hi - lo + 1 == k) {
                set.add(s.substring(lo, hi + 1));
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            hi++;
        }
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return set;
    }

    public static void main(String[] args) {
        uniqueSubstringSizeK("abcabc", 3);
        uniqueSubstringSizeK("abacab", 3);
        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
        List<Integer> l = new ArrayList<>(Arrays.asList(4,2,1,3,6,5,7));
        System.out.println(distance(new ArrayList<>(Arrays.asList(4,2,1,3,6,5,7)),1,5));

    }

    static int distance(List<Integer> nums, int node1, int node2) {
        //if (node1 > node2) swap(node1, node2);

        int low1 = Integer.MIN_VALUE, high1 = Integer.MAX_VALUE;
        int low2 = Integer.MIN_VALUE, high2 = Integer.MAX_VALUE;

        int distance = 0;
        boolean inside = false;

        for (int node : nums) {
            if (!inside) {
                if (node >= node1 && node <= node2) {
                    inside = true;
                    high1 = low2 = node;
                } else {
                    if (node < node1 && node > low1) low1 = node;
                    if (node > node2 && node < high2) high2 = node;
                    continue;
                }
            }

            if (node > low1 && node < high1) {
                distance++;
                if (node < node1) {
                    low1 = node;
                } else if (node > node1) {
                    high1 = node;
                } else {
                    low1 = high1 = node;
                }
            }
            if (node > low2 && node < high2) {
                distance++;
                if (node < node2) {
                    low2 = node;
                } else if (node > node2) {
                    high2 = node;
                } else {
                    low2 = high2 = node;
                }
            }

        }

        return (low1 == node1 && low2 == node2) ? distance : -1;
    }
}

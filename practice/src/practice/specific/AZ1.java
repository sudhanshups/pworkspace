package practice.specific;

import java.io.IOException;
import java.util.*;

public class AZ1 {

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


    static public String solution(int A, int B, int C) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        characterCountMap.put('a', A);
        characterCountMap.put('b', B);
        characterCountMap.put('c', C);

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> e : characterCountMap.entrySet()) {
            priorityQueue.add(e);
        }

        Map.Entry<Character, Integer> onHold = null;
        StringBuilder stringBuilder = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> cur = priorityQueue.poll();
            if (cur.getValue() <= 0) {
                continue;
            }
            stringBuilder.append(cur.getKey());

            if (onHold != null) {
                priorityQueue.add(onHold);
                onHold = null;
            }
            int curValue = cur.getValue();
            if (curValue > 1) {
                cur.setValue(curValue - 1);
                if (stringBuilder.length() >= 2 && cur.getKey() == stringBuilder.charAt(stringBuilder.length() - 2)) {
                    onHold = cur;
                } else {
                    priorityQueue.add(cur);
                }
            }
        }
        return stringBuilder.toString();
    }

    static public String solution(String s, int k) {
        if(s.length()<=k)
            return s;

        String sub = s.substring(0, k);
        if(s.charAt(k)== ' ') {
            return sub;
        }
        int lastIndexOfSpace = sub.lastIndexOf(' ');
        return sub.substring(0, lastIndexOfSpace);
    }


    public static void main(String[] args) throws IOException {
        System.out.println(solution(6, 1, 1));
        System.out.println(solution(1, 3, 1));
        System.out.println(solution(0, 1, 8));
        System.out.println(solution(0, 0, 0));
        System.out.println(solution(1, 1, 1));

        System.out.println(solution("abc d efg",5));

    }


}

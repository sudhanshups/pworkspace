package practice;

import java.util.*;

public class StringCodes {

    public static void main(String[] args) {
        StringCodes s = new StringCodes();
        List<String> strings = s.findStrobogrammatic(2);
        System.out.println(strings);

        //System.out.println(s.decodeString("3[a]2[bc]"));

        //group with same diff
        //System.out.println(s.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
        //System.out.println(s.groupStrings(new String[]{"ace", "ay"}));

        //rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
        System.out.println(s.wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
        }
        //count: how many valid chars have been put so far
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }


    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getBitMap(s);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            //Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    private String getBitMap(String s) {
        int[] arr = new int[s.length()];
        arr[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            arr[i] = s.charAt(i) - s.charAt(0) < 0 ?
                    ((s.charAt(i) - s.charAt(0)) % 26 + 26) : (s.charAt(i) - s.charAt(0));
        }
        return Arrays.toString(arr);
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> answer = new ArrayList<>();
        helper(answer, n, n);
        return answer;
    }

    public void helper(List<String> list, int n, int targetLen) {
        if (n == 0) {
            list.add("");
            return;
        }
        if (n == 1) {
            list.add("0");
            list.add("1");
            list.add("8");
            return;
        }
        helper(list, n - 2, targetLen);
        int size = list.size();
        int i = 0;
        while (i < size) {
            String cur = list.get(i);
            if (n != targetLen) {
                list.add("0" + cur + "0");
            }
            list.add("1" + cur + "1");
            list.add("6" + cur + "9");
            list.add("8" + cur + "8");
            list.add("9" + cur + "6");
            list.remove(0);
            size--;
        }
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> res = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder tempCount = new StringBuilder();
        res.push("");
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tempCount.append(c);
            } else if (c == '[') {
                count.push(Integer.parseInt(tempCount.toString()));
                tempCount = new StringBuilder();
                res.push("");
            } else if (c == ']') {
                String temp = res.pop();
                StringBuilder sb = new StringBuilder();
                int index = count.pop();
                for (int i = 0; i < index; i++) {
                    sb.append(temp);
                }
                res.push(res.pop() + sb.toString());
            } else {
                res.push(res.pop() + c);
            }
        }
        return res.pop();
    }
}
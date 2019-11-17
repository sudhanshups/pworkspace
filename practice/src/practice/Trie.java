package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;

    public TrieNode() {
    }
}

public class Trie {

    public static void main(String[] args) {
        System.out.println(new Integer(1).compareTo(new Integer(2)));
        TrieNode root = new TrieNode();
        String[] words = new String[]{"Sud", "Bana", "Banana"};
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        System.out.println(search(root, "Sud"));
        System.out.println(search(root, "sud"));
        System.out.println(search(root, "Bana"));
        System.out.println(search(root, "Banana"));

    }

    static void insert(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }

    static boolean search(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.children.get(word.charAt(i));
        }

        if (node.word.equals(word)) {
            return true;
        }
        return false;
    }



    //https://leetcode.com/problems/reorder-data-in-log-files/
    static String[] reorderLogFile(String[] logs) {
        Arrays.sort(logs, (u, v) -> {
            int s1F = u.indexOf(' ');
            int s2F = v.indexOf(' ');
            char s1Fc = u.charAt(s1F + 1);
            char s2Fc = v.charAt(s2F + 1);
            if (s1Fc <= '9') {
                if (s2Fc <= '9') {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (s2Fc <= '9') {
                return -1;
            }
            int preCompute = u.substring(s1F + 1).compareTo(v.substring(s2F + 1));
            if (preCompute == 0)
                return u.substring(0, s1F).compareTo(v.substring(0, s2F));
            return preCompute;
        });
        return logs;
    }
}

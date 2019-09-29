package practice;

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
}

package practice;

import java.io.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static Map<Integer, Integer> rankSearches(String[] keywords, Map<Integer, List<String>> idSearchKeyMap) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : idSearchKeyMap.entrySet()) {
            int id = entry.getKey();
            List<String> searchKeywords = idSearchKeyMap.get(id);
            int rank = 0;
            for (String searchKeyword : searchKeywords) {
                for (int i = 0; i < keywords.length; i++) {
                    int keywordCount = searchKeyword.contains(keywords[i]) ? 1 : 0;
                    rank += keywordCount;
                }
            }
            result.put(id, rank);
        }
        sortByValue(result);

        return result;

    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] keywords = line.split(",");
        Map<Integer, List<String>> idSearchKeyMap = new HashMap<>();
        int numberOfReviews = in.nextInt();
        for (int loopCounter = 0; loopCounter < numberOfReviews; loopCounter++) {
            System.out.println("Taking integer input");
            int id = in.nextInt();
            System.out.println("id " + id);
            System.out.println("Taking string input");
            String searchLine = in.nextLine();
            searchLine = in.nextLine();
            System.out.println("searchLine " + searchLine);
            if (idSearchKeyMap.containsKey(id)) {
                List<String> searchKeywords = idSearchKeyMap.get(id);
                searchKeywords.add(searchLine);
                idSearchKeyMap.put(id, searchKeywords);
            }
        }
        Map<Integer, Integer> idRankMap = rankSearches(keywords, idSearchKeyMap);

        StringBuffer result = new StringBuffer("");
        for (Map.Entry<Integer, Integer> entry : idRankMap.entrySet()) {
            result = result.append(entry.getKey() + " ");
        }
        System.out.println("Result  " + result.toString());
    }
}
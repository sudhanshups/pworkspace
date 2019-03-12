package practice;

import java.io.*;
import java.util.*;

public class Anagram {

    public static void main(String args[]) throws IOException {

        Date d = new Date();

        BufferedReader in = new BufferedReader(new FileReader(
                "/Users/sudhanshu.singh/Downloads/wordlist.text"));

        Map<String,Set<String>> map = new HashMap<>();

        String line = in.readLine();
        while (line != null) {
            //System.out.println(line);
            line = line.replace("'","").toLowerCase();
            //System.out.println("replaced "+line);

            char tempArray[] = line.toCharArray();
            Arrays.sort(tempArray);
            String sorted = new String(tempArray);
            if(!map.containsKey(sorted)){
                map.put(sorted,new HashSet<>());
            }
            map.get(sorted).add(line);
            line = in.readLine();
        }
        in.close();

        int max=0;
        Set<String> maxAna = new HashSet<>();
        for(Map.Entry<String,Set<String>> entry : map.entrySet()){
            System.out.println(entry.getValue());
            if(entry.getValue().size() >max){
                max = entry.getValue().size() ;
                maxAna = entry.getValue();
            }
        }

        System.out.println(maxAna);
        Date t = new Date();
        System.out.println(t.getTime()-d.getTime() + " miliseconds");
    }
}
//package practice.specific;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//http://codeforces.com/contest/959/problem/B

public class CF473_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = in.readLine().split(" ");
        int n = Integer.parseInt(arg[0]);
        int k = Integer.parseInt(arg[1]);
        int m = Integer.parseInt(arg[2]);

        int i,j;
        String[] words = in.readLine().split(" ");
        int[] costs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<String,Integer> wordindex = new HashMap<>();
        for(i=0;i<words.length ; i++) {
            wordindex.put(words[i],i);
        }

        for(i =0;i<k;i++){
            int[] groups = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int min = 1000000001;
            for(j=1;j<groups.length;j++){
                min = Math.min(costs[groups[j]-1],min);
            }
            for(j=1;j<groups.length;j++){
                costs[groups[j]-1]= min;
               // System.out.println(costs[groups[j]-1]+ " ");
            }
        }
        long cost= 0;
        String[] msg = in.readLine().split(" ");

       // System.out.println(wordindex.toString());

        for(i=0;i<msg.length ; i++) {
            //System.out.println(msg[i] + " word, index " + wordindex.get(msg[i]));
            cost += costs[wordindex.get(msg[i])];
        }

        System.out.println(cost);

    }
}

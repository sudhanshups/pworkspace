package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//http://codeforces.com/contest/979/problem/0
public class CF482_1 {

    public static void main(String[] args) throws IOException {
        allFactors(10);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        n = n+1;
        if(n==1){
            System.out.println("0");
        }else if (n % 2 == 1) {
            System.out.println(n);
        } else {
            System.out.println(n/2);
        }


    }
    public static ArrayList<Integer> allFactors(int A) {
        HashSet<Integer> fact = new HashSet<>();
        for(int i=1;i<= Math.sqrt(A);i++){
            if(A%i==0){
                fact.add(i);
                fact.add(A/i);
                //System.out.println(i+ " " + A/i);
            }
        }
        ArrayList<Integer> s= new ArrayList(fact);
        Collections.sort(s);
        return s;
    }
}

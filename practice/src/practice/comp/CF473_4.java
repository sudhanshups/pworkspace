package practice.comp;//package practice.specific;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//http://codeforces.com/contest/959/problem/D

public class CF473_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());

        long cost = n%2==1?1:0;
        long ln = n-1; //last node
        for(int i=0;i <ln/2+1; i++){
            cost+= i^(ln-i);
        }
        System.out.println(cost);
    }
}

package practice.specific;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//http://codeforces.com/contest/959/problem/C

public class CF473_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int i = 1, j = 1;
        if (n < 6) {
            System.out.println("-1");
        } else {
            int rootEdge = (n - 1) - n / 2;
            for (j = 1; j <= rootEdge; j++) {
                System.out.println(i + " " + (1 + j));
            }
            j++;
            for (; j <= n; j++) {
                System.out.println("2 " + j);
            }
        }
        for (j = 1; j < n; j++) {
            System.out.println("1 " + (1 + j));
        }
    }
}

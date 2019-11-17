package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class Solution{
public class CJ192 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 1; k <= t; k++) {
            int N = Integer.parseInt(in.readLine());
            String grid = in.readLine();
            StringBuilder ans = new StringBuilder();
            for (char c : grid.toCharArray()) {
                if (c == 'S') {
                    ans.append('E');
                } else {
                    ans.append('S');
                }

            }

            System.out.println("Case #" + k + ": " + ans);
        }

    }
}

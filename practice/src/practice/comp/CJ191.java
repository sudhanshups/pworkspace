package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class Solution{
public class CJ191 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 1; k <= t; k++) {
            String num = in.readLine();
            StringBuilder one = new StringBuilder();
            StringBuilder two = new StringBuilder();
            boolean firstFourFound = false;
            for (char c : num.toCharArray()) {
                if (c != '4') {
                    if (firstFourFound) {
                        two.append('0');
                        one.append(c);
                    } else {
                        one.append(c);
                    }
                }
                if (c == '4') {
                    firstFourFound = true;
                    one.append('2');
                    two.append('2');
                }

            }

            System.out.println("Case #" + k + ": " + one + " " + two);
        }

    }
}

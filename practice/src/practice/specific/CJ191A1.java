package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//public class Solution{
public class CJ191A1 {
    class P {
        int a;
        int b;

        P(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 1; k <= t; k++) {
            String[] nums = in.readLine().split(" ");

            int r = Integer.parseInt(nums[0]);
            int c = Integer.parseInt(nums[1]);
            if ((r < 5 && c < 5) || (Math.min(r, c) == 3 && Math.max(r, c) == 5)) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
                continue;
            }
            boolean[][] mat = new boolean[r][c];
            Set<P> order = new LinkedHashSet<>();
            int count = 0;
            while (count != r * c){

            }

                //System.out.println("Case #" + k + ": " + one + " " + two);
        }

    }

    public static int nextRow(int i, int r) {
        return (i + 1) % r;
    }

    public static int nextCol(int i, int c) {
        return (i + 2) % c;
    }
}

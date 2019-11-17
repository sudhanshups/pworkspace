package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class Solution{
public class CJ191B1 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);

        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int XPluMove[] = new int[q+1];
            int XMinMove[] = new int[q+1];
            int YPluMove[] = new int[q+1];
            int YMinMove[] = new int[q+1];

            int a, b;
            for (int i = 0; i < p; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                String c = sc.next();
                if (c.equals("N")) {
                    YPluMove[b + 1]++;
                    //  XMove[arr[i][0]]++;

                } else if (c.equals("S")) {
                    YMinMove[b - 1]++;
                    //XMove[arr[i][0]]++;
                } else if (c.equals("E")) {
                    XPluMove[a + 1]++;
                    // YMove[arr[i][1]]++;
                } else {
                    XMinMove[a - 1]++;
                    //YMove[arr[i][1]]++;
                }
            }

            //count no of people can reach at any positive point on x axis moving ++
            for (int i = 1; i <= q; i++) {
                XPluMove[i] += XPluMove[i - 1];
            }
            for (int i = q - 1; i >= 0; i--) {
                XMinMove[i] += XMinMove[i + 1];
            }
            //max people at any point on x axis for each

            int xMax = -1;
            int xMaxIndex = -1;
            for (int i = 0; i <= q; i++) {
                if (xMax < (XPluMove[i] + XMinMove[i])) {
                    xMax = XPluMove[i] + XMinMove[i];
                    xMaxIndex = i;
                }
            }

            // same for y axis
            for (int i = 1; i <= q; i++) {
                YPluMove[i] += YPluMove[i - 1];
            }
            for (int i = q - 1; i >= 0; i--) {
                YMinMove[i] += YMinMove[i + 1];
            }
            //same for y
            int yMax = -1;
            int yMaxIndex = -1;
            for (int i = 0; i <= q; i++) {
                if (yMax < (YPluMove[i] + YMinMove[i])) {
                    yMax = (YPluMove[i] + YMinMove[i]);
                    yMaxIndex = i;
                }
            }

            System.out.println("Case #" + k + ": " + xMaxIndex + " " + yMaxIndex);

        }
    }
}

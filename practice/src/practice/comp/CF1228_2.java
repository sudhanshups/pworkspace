package practice.comp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1228_2 {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int col[] = new int[w];
        int row[] = new int[h];
        int[][] arr = new int[2][w + 1];
        for (int i = 0; i < h; i++) {
            row[i] = sc.nextInt();
        }
        for (int i = 0; i < w; i++) {
            col[i] = sc.nextInt();
            arr[0][i] = 1;
        }


        arr[0][w] = 1;
        arr[1][0] = 1;

        int r = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                r = i % 2;
                //precheck
                if ((row[i - 1] - (j - 1)) == 0 && (col[j - 1] - (i - 1)) == 0) {

                }else if((row[i - 1] - (j - 1)) < 0 && (col[j - 1] - (i - 1)) == 0){

                }

                if ((row[i - 1] - (j - 1)) >= 0 || (col[j - 1] - (i - 1)) >= 0) {
                    arr[r][j] = Math.max(arr[(i + 1) % 2][j], arr[r][j - 1]);
                } else{
                    arr[r][j] = (arr[(i + 1) % 2][j - 1] * 2) % 1000000007;
                }
            }
        }
        System.out.println(arr[h % 2][w]);
    }
}
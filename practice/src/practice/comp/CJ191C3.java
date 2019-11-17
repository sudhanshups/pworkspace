package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//public class Solution{
public class CJ191C3 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);

        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int verticalColonyMark[] = new int[col];
            int horizontalColonyMark[] = new int[row];
            String[] arr = new String[row];
            int a, b;
            for (int r = 0; r < row; r++) {
                arr[r] = sc.next();
                for (int c = 0; c < col; c++) {
                    if (arr[r].charAt(c) == '#') {
                        verticalColonyMark[c] = -1;
                        horizontalColonyMark[r] = -1;
                    }
                }
            }
            int res = 0;
            boolean isHorizontalColony = true;
            boolean isBecca = true;
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, isHorizontalColony)) {
                        visited[i][j] = true;
                        horizontalColonyMark[i] = 1;
                        res += (canBeccaWinCount(row, col, visited, verticalColonyMark,
                                horizontalColonyMark, !isBecca) >= 1 ? 1 : 0);
                        visited[i][j] = false;
                        horizontalColonyMark[i] = 0;
                    }
                    if (isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, !isHorizontalColony)) {
                        visited[i][j] = true;
                        verticalColonyMark[j] = 1;
                        res += (canBeccaWinCount(row, col, visited, verticalColonyMark,
                                horizontalColonyMark, !isBecca) >= 1 ? 1 : 0);
                        visited[i][j] = false;
                        verticalColonyMark[j] = 0;
                    }
                }
            }

            System.out.println("Case #" + k + ": " + res);

        }
    }

    public static boolean isSafe(int r, int c, boolean[][] visited, int[] verticalColonyMark,
                                 int[] horizontalColonyMark, boolean isHorizontalColony) {
        if (visited[r][c])
            return false;
        if (isHorizontalColony) {
            return horizontalColonyMark[r] != -1 && verticalColonyMark[c] == 0 ;
        } else {
            return verticalColonyMark[c] != -1 && verticalColonyMark[c] == 0 ;
        }
    }

    public static int canBeccaWinCount(int row, int col, boolean[][] visited, int[] verticalColonyMark,
                                       int[] horizontalColonyMark, boolean isBecca) {
        boolean isHorizontalColony = true;
        boolean moveDone = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, isHorizontalColony)
                        || isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, !isHorizontalColony)) {
                    moveDone = true;
                    break;
                }
            }
            if (moveDone)
                break;
        }
        int res = 0;
        if (!moveDone) {
            if (isBecca)
                return 0;
            else
                return 1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, isHorizontalColony)) {
                    visited[i][j] = true;
                    horizontalColonyMark[i] = 1;
                    res += canBeccaWinCount(row, col, visited, verticalColonyMark, horizontalColonyMark, !isBecca);
                    visited[i][j] = false;
                    horizontalColonyMark[i] = 0;
                }
                if (isSafe(i, j, visited, verticalColonyMark, horizontalColonyMark, !isHorizontalColony)) {
                    visited[i][j] = true;
                    verticalColonyMark[j] = 1;
                    res += canBeccaWinCount(row, col, visited, verticalColonyMark, horizontalColonyMark, !isBecca);
                    visited[i][j] = false;
                    verticalColonyMark[j] = 0;
                }
            }
        }

        return res;
    }
}

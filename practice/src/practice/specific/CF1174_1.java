package practice.specific;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF1174_1 {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();

        int i, j=0;
        int[] tests = new int[2*n];
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (i = 0; i < n * 2; i++) {
            tests[i] = sc.nextInt();
            if (i < n) {
                firstHalfSum += tests[i];
            } else {
                secondHalfSum += tests[i];
            }
        }

        if (firstHalfSum == secondHalfSum) {
            for (j = n; j < 2 * n; j++) {
                if (tests[j] != tests[0]) {
                    int temp = tests[0];
                    tests[0] = tests[j];
                    tests[j] = temp;
                    break;
                }
            }
        }
        if (j == 2 * n) {
            System.out.print(-1);
            return;
        } else {
            for (i = 0; i < 2 * n; i++) {
                System.out.print(tests[i] + " ");
            }
        }


    }
}
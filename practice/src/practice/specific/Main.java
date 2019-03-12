package practice.specific;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int N = sc.nextInt();
        int cost = sc.nextInt();
        int totalCoin = 1000;

        //binary search
        int l = 1, h = N;
        int m = (l + h) / 2;

        int pm = -1;
        boolean pbroken = false;
        while (totalCoin >= (cost + (m - l + 1)) && l < h) {
            System.out.println(1 + " " + m);
            System.out.flush();
            totalCoin--;
            int r = sc.nextInt();

            if (r == 1) {
                totalCoin -= cost;
                if ((!pbroken && pm != -1 && (pm + 1) == m) || m == l) {
                    System.out.println(3 + " " + m);
                    System.out.flush();
                    return;
                }
                System.out.println(2);
                System.out.flush();
                pbroken = true;
                h = m;
            } else {
                l = m + 1;
                pbroken = false;
            }
            pm = m;
            m = (l + h) / 2;
        }

        int i = l;
        for (i = l; i < h; i++) {
            System.out.println(1 + " " + i);
            System.out.flush();
            totalCoin--;
            int r = sc.nextInt();
            if (r == -1) {
                continue;
            } else if (r == 1) {
                System.out.println(3 + " " + i);
                break;
            } else if (totalCoin == 0) {
                System.out.println(3 + " " + (i + 1));
                break;
            }
        }
        if (i == h)
            System.out.println(3 + " " + h);
        System.out.flush();
    }
}
    /*
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);

        int T = sc.nextInt();
        int N = sc.nextInt();
        int r;
        while (T-- > 0) {
            int[] arr = new int[N];
            for (int i = 1; i <= N; i++) {
                System.out.printf("%d %d %d %d", 1, i, i, i);
                System.out.println();
                System.out.flush();
                arr[i - 1] = sc.nextInt();
            }

        /*while (T-- > 0) {
            int[] arr = new int[N];
            for (int i = 1; i <= N; i++) {
                if (i == N) {
                    System.out.printf("%d %d %d %d", 1, N, N, 1);
                    System.out.println();
                    System.out.flush();

                    r = sc.nextInt();
                    if (r != -1)
                        arr[0] = r;
                } else {
                    System.out.printf("%d %d %d %d", 1, i, i, i + 1);
                    System.out.println();
                    System.out.flush();

                    r = sc.nextInt();
                    if (r != -1)
                        arr[i] = r;
                }
            }
            System.out.print("2");
            for (int i = 0; i < N; i++)
                System.out.print(" " + arr[i]);
            System.out.println();
            r = sc.nextInt();
            System.out.flush();
        }
    }*/

    /*public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int N = sc.nextInt();
        int cost = sc.nextInt();
        int totalCoin = 1000;

        //binary search
        int l = 1, h = N;
        int m = (l + h) / 2;

        int pm = -1;
        boolean pbroken = false;
        while (totalCoin >= (cost + (m - l + 1)) && l < h) {
            System.out.println(1 + " " + m);
            System.out.flush();
            totalCoin--;
            int r = sc.nextInt();

            if (r == 1) {
                totalCoin -= cost;
                if ((!pbroken && pm != -1 && (pm + 1) == m)||m==l ) {
                    System.out.println(3 + " " + m);
                    System.out.flush();
                    return;
                }
                System.out.println(2);
                System.out.flush();
                pbroken = true;
                h = m;
            } else {
                l = m + 1;
                pbroken = false;
            }
            pm = m;
            m = (l + h) / 2;
        }

        int i = l;
        for ( i = l; i < h; i++) {
            System.out.println(1 + " " + i);
            System.out.flush();
            totalCoin--;
            int r = sc.nextInt();
            if (r == -1) {
                continue;
            } else if (r == 1) {
                System.out.println(3 + " " + i);
                break;
            } else if (totalCoin == 0) {
                System.out.println(3 + " " + (i + 1));
                break;
            }
        }
        if(i==h)
            System.out.println(3 + " " + h);
        System.out.flush();
    }

    */




package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TR1 {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(in.readLine());

/*        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList( 2147483647, 2000000014, 2147483647));
        System.out.println(ibit.macChocolate(chocolates, 10));*/

        System.out.println(flowerBouquets(2, 3, "0001000"));


    }


    public static int flowerBouquets(int p, int q, String s) {

        char[] flower = s.toCharArray();
        int[] arr = new int[flower.length + 1];

        for (int i = 1; i < flower.length; i++) {
            //arr is of +1
            int dpIndex = i + 1;

            int cosmosRose = 0;
            int threeRose = 0;

            if ((flower[i] == '0' && flower[i - 1] == '1') || (flower[i] == '1' && flower[i - 1] == '0')) {
                cosmosRose = q;
            }
            if (i >= 2 && flower[i] == '0' && flower[i] == flower[i - 1] && flower[i - 1] == flower[i - 2]) {
                threeRose = p;
            }

            if (i < 2) {
                arr[dpIndex] = cosmosRose;
            } else if (cosmosRose + arr[i - 1] > arr[i - 2] + threeRose) {
                arr[dpIndex] = cosmosRose + arr[i - 1];
            } else if (cosmosRose + arr[i - 1] < arr[i - 2] + threeRose) {
                arr[dpIndex] = arr[i - 2] + threeRose;
            }
            if(arr[dpIndex] <arr[i])
                arr[dpIndex]=arr[i];
        }

        return arr[flower.length];
    }
}

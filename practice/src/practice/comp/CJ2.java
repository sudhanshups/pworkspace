package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CJ2 {

    public static int getIndex(int [] arr, int n) {
        int oddLength = n/2; //0 2 4
        if(n%2==1)
            oddLength = (n/2)+1;

        int []odd = new int[oddLength];
        int []even = new int[n/2];

        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                odd[j++]=arr[i];
            }else{
                even[k++]=arr[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        j=0;k=0;
        int p=odd[j++];
        int c=0;
        for(int i=1;i<n;i++) {
            if (i % 2 == 0) {
                c = odd[j++];
            } else {
                c = even[k++];
            }
            if (p > c)
                return i-1;
            p = c;
        }
        return -1;
}


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(in.readLine());
            int [] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int index = getIndex(arr, n);
            if(index==-1)
                System.out.println("Case #" + k + ": OK");
            else
                System.out.println("Case #" + k + ": "+index);
        }
    }
}

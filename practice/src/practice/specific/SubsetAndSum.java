package practice.specific;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SubsetAndSum {

    /*    static long findWays(long n,int [][]arr ){
            if(n<=0||n==1||n==3)
                return 0;
            if(n==arr[0][0])
                return arr[0][1];
            else if(n==arr[1][0])
                return arr[1][1];
            else if(n==arr[2][0])
                return arr[2][1];


            long ways =0;
            if(n>5){
                ways+=(arr[0][1] * findWays(n-arr[0][0],arr)) //2 and 4
                        + (arr[1][1] * findWays(n-arr[1][0],arr)) -2
                + (arr[2][1] * findWays(n-arr[2][0],arr)) ; // for 5
            }


            return 1l;
        }
    */
    public static void main(String[] args) throws IOException {

        int [] arr = {1,2,3};
        System.out.println(getSubsetSum(arr));



    }

    static long getsum(List<Integer> subset){
        long and = subset.get(0);
        for(int i=1;i<subset.size();i++){
            and = and &subset.get(i);
            if(and>=1000000007)
                and = and%1000000007;
        }
        return and;

    }
    static long subsetsSumUtil(int[] arr,int index,List<Integer> subset) {
        long sum =0;
        for (int i = index; i < arr.length; i++) {
            subset.add(arr[i]);
            sum = sum + getsum(subset)+ subsetsSumUtil(arr, i + 1,subset);
            subset.remove(subset.size()-1);
            if(sum>=1000000007)
                sum = sum%1000000007;
        }
        return sum;
    }

    /*
    for (int i = index; i < arr.length; i++) {
    78 subset.add(arr[i]);
    79 sum = sum + getsum(subset)+ subsetsSumUtil(arr, i + 1,subset);
    80 subset.remove(subset.size()-1);
    81 }
      line 79 me error h
     */

    /*

    or (int i = index; i < arr.length; i++) {
           subset.add(arr[i]);
           if(sum>=1000000007)
               sum = sum%1000000007;
           sum = sum + getsum(subset);
           if(sum>=1000000007)
               sum = sum%1000000007;
           sum += subsetsSumUtil(arr, i + 1,subset);
           subset.remove(subset.size()-1);
       }

     */
    static long getSubsetSum(int[] arr) {
        int n = arr.length;
        List<Integer> subset = new ArrayList<>();
        return subsetsSumUtil(arr, 0,subset );
    }

}

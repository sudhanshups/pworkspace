package practice.specific;


import java.io.IOException;
import java.util.ArrayDeque;

class FinalPrice {


    public static void main(String[] args) throws IOException {

//        int [] arr = {2,3,1,2,4,2};
        int [] arr = {5,1,3,4,6,2};

        finalPrice(arr);
    }

    static void finalPrice(int[] prices) {

        int finalPrice[] = new int[prices.length];

        ArrayDeque<Integer> index = new ArrayDeque<>();
        int i=0;
        int j=0;
        index.add(i++);
        while( i< prices.length || !index.isEmpty() ){
            int firstVal = prices[index.getFirst()];
            int lastVal = prices[index.getLast()];

            if(prices[index.getFirst()]>=prices[index.getLast()] && index.getFirst() != index.getLast()){
                finalPrice[j++] = prices[index.getFirst()]-prices[index.getLast()];
                index.removeFirst();
            }else if(i>=prices.length){
                finalPrice[j++] = prices[index.getFirst()];
                index.removeFirst();
            }
            else //(i<prices.length){
                index.addLast(i++);
            //}
        }

        int sum=0;
        for(i=0;i<prices.length;i++){
            sum += finalPrice[i];
            //System.out.println(finalPrice[i]);
        }
        System.out.println(sum);
        for(i=0;i<prices.length;i++){
            if(prices[i]==finalPrice[i])
                System.out.print(i+" ");
        }
    }
}

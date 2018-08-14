package practice;

import java.util.Scanner;
import java.util.stream.Stream;
//salesforce
public class maxSumInTrianle {

	static int max(int a,int b){
		if(a>b)
			return a;
		else return b;
	}
	static int sumTriangle(String[] triangle) {
	        int lastRowSize = triangle.length;
			// System.out.println( lastRowSize);	
	        int[] sum = new int[lastRowSize];//[2];
	        int i,j,k;
	        for(i = 0;i<lastRowSize;i++ ){
	        	sum[i]=0;
	        }
	        
	        String[] token = triangle[0].split(" ");
	        int[] firstRow = new int[token.length];
	        i=0;
	        for (String t : token){
	        	firstRow[i++] = Integer.parseInt(t); 
	        }
	        
	        sum[0]= firstRow[0];
	        
	        for(i = 1;i<lastRowSize;i++ ){
	        	String[] tokens = triangle[i].split(" ");
		        int[] array = new int[tokens.length];
		        k=0;
		        for (String t : tokens){
		        	array[k++] = Integer.parseInt(t); 
		        }
	        	
		        System.out.println(i + "=i, length= "+ array.length +" T "+ triangle[i]);
		        for(j=array.length-1; j>=0;j--){
		        	System.out.print("before " + sum[j] );
		        	if(j==0){
		        		sum[j]+=array[j];
		        	}else if(j==array.length-1){
		        		sum[j] = sum[j-1]+ array[j]; 
		        		//array[j]; --> max(array[j],array[j-1]);
		        	}else{
		        		sum[j] = max(sum[j],sum[j-1])+array[j];
		        		//max(sum[j],sum[j-1])+array[j]-->
		        		//max(array[j],array[j-1])
		        	}
		        System.out.print(" "+sum[j]);
		        System.out.println();
		        }
		        System.out.println(" ---- ");
	        }
	        int maxSum=0;
	        for(i = 0;i<lastRowSize;i++ ){
	        	if(sum[i]>maxSum)
	        		maxSum=sum[i];
	        }
	        return maxSum;

	    }


	public static void main(String args[]) throws Exception {
		String s[] = new String[4];
		s[0] = new String("1");
		s[1] = new String("2 3");
		s[2] = new String("6 5 4");
		s[3] = new String("10 7 8 9");
		System.out.println(sumTriangle(s));
		//int[] array = Stream.of(s[2].split(" ")).mapToInt(token -> Integer.parseInt(token)).toArray();
		//for (int i = 0; i < array.length; i++)
		//	System.out.println(array[i]);
	}
}
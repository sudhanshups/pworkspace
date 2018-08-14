package practice;

import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int arr[] = new int[26];
		for(int i=0;i<26 ;i++)
			arr[i]=-2;
		// saleforceigoodcompnytowork
		
		for(int i=0;i<line.length();i++ ){
			
			//System.out.println(line.charAt(i)-'a' + "  " +arr[line.charAt(i)-'a']+"  "+i);
			
			if(arr[line.charAt(i)-'a']==-2 ){
				arr[line.charAt(i)-'a']=i;
			}
			else if (arr[line.charAt(i)-'a'] >=0){
				arr[line.charAt(i)-'a']=-1;
			}
			//System.out.println(" stored value" + arr[line.charAt(i)-'a']);
		}
		int min=line.length();
		for(int i=0;i<26;i++){
			System.out.println( arr[i]+" min= "+ min);
			if( arr[i] >=0 && arr[i]<min){
				min=arr[i];
			}
		}
		System.out.println(line.charAt(min));
		in.close();
	}
}
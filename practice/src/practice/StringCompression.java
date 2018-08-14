package practice;

import java.util.Scanner;

public class StringCompression {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String compressed=new String();
		int c =0,j=0;
		for(int i=0;i<line.length();i++ ){
			if(line.charAt(i)==line.charAt(j)){
				c++;
			}
			else{
				compressed+=line.charAt(j) + Integer.toString(c);
				j=i;
				c=1;
			}
			System.out.println("Line "+compressed);
		}
		compressed+=line.charAt(j) + Integer.toString(c);
		System.out.println("Line "+compressed);
		in.close();
	}
}
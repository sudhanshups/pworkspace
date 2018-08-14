package practice;

import java.util.Scanner;

public class XPowerY {

	public static void main(String args[]) throws Exception {
		//input:  2 3
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		
		int r=1,p=x;
		while(y!=0){
			if((y&1)==1){
				r=r*p;
			}
			p=p*p;
			y=y/2;
		}
		System.out.println(r);
		in.close();
	}
}
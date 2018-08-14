package practice;
//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// public class Codeforces1 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int a = Integer.parseInt(s[1]);
		int b = Integer.parseInt(s[2]);

		if(a>b){
			int x=a;
			a=b;
			b=x;
		}
		if(a!=2*(a/2))
			a=a+1;
		if(b!=2*(b/2))
			b=b+1;
		
		int d = b - a;
		
		int rounds = 0, played = 0,playeda=0,playedb=0;
		for (int i = 1; i < 9; i++) {
			if (1 << i == n) {
				rounds = i;
			}
			
			if(a > 1<<(i-1) && a <= 1<<i ){
				playeda=i;
			}
			if(b > 1<<(i-1) && b <= 1<<i ){
				playedb=i;
			}
			
		}

		System.out.println(rounds);
		if (d == 1 && a < 4) {
			if (a != 2 * (a / 2)) {
				played = 1;
			} else // if (d == 1 && a == 2 * (a / 2)) {
				played = 2;
		} else {
			for (int i = 1; i < 9; i++) {
				System.out.println(d +"=d "+ (1<<i) + " , "+ (1 << (i + 1)));

				if (d >= 1 << i && d < 1 << (i + 1)) {
					played = i + 1;
					break;
				}
			}
		}

		System.out.println(played);
		if (played == rounds)
			System.out.println("Final!");
		else
			System.out.println(played);

	}

}
package practice;

import java.util.Scanner;

class Snake {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a[][]=new int[2][100001];
		int n = 0;
		while(t-->0){
			n = in.nextInt();
			char c[] = in.next().toCharArray();
			char d[] = in.next().toCharArray();
			for(int i=0;i<n;i++){
				if(c[i]=='*')a[0][i]=1;
				else a[0][i]=0;
				
				if(d[i]=='*')a[1][i]=1;
				else a[1][i]=0;
			}
			solve(a,n);
		}
		in.close();
	}

	private static void solve(int[][] a, int n) {
		boolean horizontal = false;
		if((a[0][0]==1 || a[0][1]==1) && (a[1][0]==1 || a[1][1]==1)){
			horizontal=true;
		}else{
			for(int i=1;i<n-2;i++){
				if(a[0][i]==1 && (a[1][i]==1 || a[1][i-1]==1 || a[1][i+1]==1)){
					horizontal=true;
					break;
				}
			}
			if(!horizontal){
				if(a[0][n-1]==1 && (a[1][n-1]==1 || a[1][n-2]==1)){
					horizontal = true;
				}
			}
		}
		int divide=0;
		for(int i=0;i<n-1;i++){
			if(a[0][i]==1 && a[0][i+1]==1){
				divide++;
			}else if(a[1][i]==1 && a[1][i+1]==1){
				divide++;
			}
		}
		if(horizontal){
			divide++;
		}
		System.out.println(divide);
		
	}

}

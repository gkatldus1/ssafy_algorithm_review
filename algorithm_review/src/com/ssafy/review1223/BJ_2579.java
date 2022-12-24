package com.ssafy.review1223;

import java.util.Scanner;

public class BJ_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] st = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=0; i<N; i++) {
			st[i+1] = sc.nextInt();
		}
		
		if(N==1) {
			System.out.println(st[1]);
			return;
		}
		if(N==2) {
			System.out.println(st[1]+st[2]);
			return;
		}
		
		dp[1] = st[1];
		dp[2] = st[2] + dp[1];
		dp[3] = Math.max(st[1], st[2]) + st[3];
		for(int i=4; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + st[i-1] + st[i], dp[i-2] + st[i]);
//			dp[i] = Math.max(dp[i], dp[i-3]+st[i]);
		}
		System.out.println(dp[N]);
//		for(int i=1; i<=N; i++) {
//			System.out.print(dp[i]+" ");
//		}
		
	}
}

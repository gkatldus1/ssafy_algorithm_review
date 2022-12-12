package com.ssafy.review1210;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		if(N>1) {
			dp[2] = 1;
		}
		if(N>2) {
			dp[3] = 1;
		}
		
		if(N<=3) {
			System.out.println(dp[N]);
			return;
		}
		
		
		for(int i=4; i<=N; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
		}
		
		
		
		System.out.println(dp[N]);
	}
}

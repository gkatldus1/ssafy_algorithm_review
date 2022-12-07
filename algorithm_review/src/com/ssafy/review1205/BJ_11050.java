package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050 {
	
	
//	for(int i = 0; i < 30; i++) {
//		dp[i][0] = 1;	// nC0 = 1
//		dp[i][i] = 1;	// nCn = 1
//	}
//	
//	for(int i = 1; i < 30; i++) {
//		for(int j = 1; j < 30; j++) {
//			dp[i][j] = dp[i-1][j-1] + dp[i-1][j];	// nCk = n-1Ck-1 + n-1Ck
//		}
//	}
//
//
//static int combi(int n, int r) {
//
//
//    if(dp[n][r] > 0) {
//        return dp[n][r];
//    }
//
//
//    if(n == r || r == 0) {
//        return dp[n][r] = 1;
//    }
//
//
//    return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
//}
//	
	
	
	
	
	
	static int[][] dp = new int[11][11];
	
	public static void main(String[] args) throws Exception {
		for(int i=0; i<11; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		// nCk = n-1Ck-1 + n-1Ck
		for(int i=1; i<11; i++) {
			for(int j=1; j<11; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		System.out.println(dp[n][r]);
		
		
		
	}
	
}

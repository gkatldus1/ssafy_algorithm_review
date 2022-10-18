package com.ssafy.review1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_복습3 {
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		dp = new int[30][30];
		
		
		
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());
			
//			
//			for(int[] arr : dp) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			
			System.out.println(combi(east, west));
			
		}
	}
	
	static int combi(int n, int r) {
		if(dp[n][r] >0)	return dp[n][r];
		
		if(n==r || r == 0)	return dp[n][r] = 1;
		
		return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
		
	}
	
	
}

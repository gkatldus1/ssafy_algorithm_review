package com.ssafy.review1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1010_복습 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		int[][] dp = new int[30][30];
		
		// 2번 성질 (n == r, r == 0)
		for(int i=0; i<30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				// 1번 성질 
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());
			
//			
//			for(int[] arr : dp) {
//				System.out.println(Arrays.toString(arr));
//			}
		
			
			System.out.println(dp[east][west]);
			
		}
		
		
	}
}

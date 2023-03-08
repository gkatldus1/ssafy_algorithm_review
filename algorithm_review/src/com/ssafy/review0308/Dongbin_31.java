package com.ssafy.review0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_31 {
	static int testCase, n, m;
	static int[][] arr = new int[20][20];
	static int[][] dp = new int[20][20];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					dp[i][j] = arr[i][j];
				}
			}
			
			for(int j=1; j<m; j++) {
				for(int i=0; i<n; i++) {
					int leftUp, leftDown, left;
					if(i==0)	leftUp = 0;
					else 	leftUp = dp[i-1][j-1];
					
					if(i==n-1)	leftDown = 0;
					else leftDown = dp[i+1][j-1];
					
					left = dp[i][j-1];
					dp[i][j] += Math.max(leftDown, Math.max(leftUp, left));
				}
			}
			int result = 0;
			for(int i=0; i<n; i++) {
				result = Math.max(result, dp[i][m-1]);
			}
//			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			
			System.out.println(result);
		}
		
		
	}
	
	
}

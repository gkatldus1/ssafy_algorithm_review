package com.ssafy.review0309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {
	
	static int n;
	static int[] t = new int[15];
	static int[] p = new int[15];
	static int[] dp = new int[16];
	static int maxValue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i= n-1; i>=0; i--) {
			int time = t[i] + i;
			if(time <= n) {
				dp[i] = Math.max(p[i] + dp[time], maxValue);
				maxValue = dp[i];
			}
			else dp[i] = maxValue;
		}
//		for(int i=0; i<=n; i++) {
//			System.out.println(dp[i]);
//		}
		System.out.println(maxValue);
		
	}
}

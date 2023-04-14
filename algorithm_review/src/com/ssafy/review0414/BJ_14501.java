package com.ssafy.review0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class BJ_14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N];
		int[] p = new int[N];
		int[] dp = new int[N+1];
		
		int maxVal = 0;
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>=0; i--) {
			int time = t[i] + i;
			if(time <= N) {
				dp[i] = Math.max(p[i] + dp[time], maxVal);
				maxVal = dp[i];
			}
			else
				dp[i] = maxVal;
		}
		System.out.println(maxVal);
	}
}

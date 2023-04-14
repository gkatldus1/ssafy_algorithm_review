package com.ssafy.review0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class BJ_18353 {
	
	static int n;
	static ArrayList<Integer> v = new ArrayList<>();
	static int[] dp = new int[2000];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			v.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.reverse(v);
		
		for(int i=0; i<n; i++) {
			dp[i] = 1;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(v.get(j) < v.get(i)) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			maxValue = Math.max(maxValue, dp[i]);
		}
		System.out.println(n - maxValue);
		
	}
	
}

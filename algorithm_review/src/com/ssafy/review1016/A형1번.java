package com.ssafy.review1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A형1번 {
	public static void main(String[] args) throws Exception {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] > max)	max = arr[i];
			}
			int sum= 0;
			for(int i=0; i<N; i++) {
				sum += max - arr[i];
			}
			
			int cnt = (sum/3) *2;
			int rest = sum %3;
			
			if(rest == 1) {
				cnt += 1;
			}else if(rest==2){
				cnt += 2;
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
		
	}
}

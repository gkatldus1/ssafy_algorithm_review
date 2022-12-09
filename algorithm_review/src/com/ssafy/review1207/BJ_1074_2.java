package com.ssafy.review1207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_2 {
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		findZ(N,r,c);
		System.out.println(ans);
	}
	
	static void findZ(int N, int r, int c) {
		if(N==0)	return;
		int size = (int)Math.pow(2, N);
		int half = size/2;
		
		if(r/half==0 && c/half==0) {
			findZ(N-1, r%half, c%half);
		}else if(r/half==0 && c/half==1) {
			ans+= half*half*1;
			findZ(N-1, r%half, c%half);
		}else if(r/half==1 && c/half==0) {
			ans+= half*half*2;
			findZ(N-1, r%half, c%half);
		}else if(r/half==1 && c/half==1) {
			ans+= half*half*3;
			findZ(N-1, r%half, c%half);
		}
		
		
	}
	
}

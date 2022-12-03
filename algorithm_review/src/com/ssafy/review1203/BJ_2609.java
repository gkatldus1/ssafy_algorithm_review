package com.ssafy.review1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int gcd = 0;
		
		if(N<M) {
			gcd = GCD(M,N);
		}else {
			gcd = GCD(N,M);
		}
		
		int lcm = M*N/gcd;
		sb.append(gcd).append("\n").append(lcm);
		System.out.println(sb);
		
		
	}
	static int GCD(int n, int m) {
		int remain = n%m;
		
		while(remain!=0) {
			n = m;
			m = remain;
			remain = n%m;
		}
		
		return m;
	}
}

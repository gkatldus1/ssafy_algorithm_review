package com.ssafy.review0123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_6064 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) -1;
			int y = Integer.parseInt(st.nextToken()) -1;
			
			int lcm = M*N/GCD(M, N);
			boolean flag = false;
			
			
			for(int i=x; i<=lcm; i+=M) {
				if(i%N == y) {
					System.out.println(i+1);
					flag = true;
					break;
				}
			}
			
			if(!flag)	System.out.println(-1);
			
			
		}
		return;
		
	}
	
	static int GCD(int a, int b) {
		if(a%b==0)	return b;
		else return GCD(b, a%b);
	}
	
}

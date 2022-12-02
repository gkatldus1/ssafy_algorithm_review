package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			if(i==1) {
				continue;
			}
			
			boolean flag = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println(i);
		}
		
	}
}

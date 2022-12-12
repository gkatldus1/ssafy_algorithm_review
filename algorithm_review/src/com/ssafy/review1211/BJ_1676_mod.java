package com.ssafy.review1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1676_mod {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt_2 = 0;
		int cnt_5 = 0;
		
		for(int i=1; i<=N; i++) {
			int num = i;
			while(num%2==0) {
				cnt_2++;
				num /= 2;
			}
			
			while(num%5==0) {
				cnt_5++;
				num/=5;
			}
			
			
		}
		int ans = Math.min(cnt_2, cnt_5);
		System.out.println(ans);
		
	}
}

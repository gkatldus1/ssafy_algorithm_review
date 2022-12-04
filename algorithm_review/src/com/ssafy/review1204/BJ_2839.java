package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N>=3) {
			if(N%5==0) {
				N -= 5;
				count++;
			}else {
				N -= 3;
				count++;
			}
		}
		
		if(N != 0) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
		
	}
}

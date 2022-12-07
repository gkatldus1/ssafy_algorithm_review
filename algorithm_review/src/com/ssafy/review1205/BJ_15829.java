package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15829 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int M = 1234567891;
		int r = 31;
		String str = br.readLine();
		long sum  = 0;
		long pow = 1;
		for(int i=0; i<L; i++) {
			long num = str.charAt(i)-'a'+1;
			sum += num * pow % M;
			pow = pow * 31 % M;
		}
		System.out.println(sum%M);	
		
	}
}

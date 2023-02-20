package com.ssafy.review0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_18406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int len = N.length();
		int left = 0;
		int right = 0;
		
		for(int i=0; i<len/2; i++) {
			left += (N.charAt(i)-'0');
		}
		for(int i=len/2; i<len; i++) {
			right += (N.charAt(i)-'0');
		}
		
		if(left == right) {
			System.out.println("LUCKY");
		}
		else {
			System.out.println("READY");
		}
		
	}
}

package com.ssafy.review1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_1676 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		

		BigInteger factorial = BigInteger.ONE;
		for(int i=1; i<=N; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		String str = String.valueOf(factorial);
//		System.out.println(str);
		int count = 0;
		for(int i=str.length()-1; i>=0; i--) {
			if(str.charAt(i) == '0') {
				count++;
			}
			else {
				break;
			}
		}
		System.out.println(count);
		
	}
}

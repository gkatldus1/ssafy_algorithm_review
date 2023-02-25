package com.ssafy.review0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Dongbin_11_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		long result= str.charAt(0)-'0';
		
		for(int i=1; i<str.length(); i++) {
			int num = str.charAt(i) - '0';
			if(num <=1 || result <=1) {
				result += num;
			}
			else {
				result *= num;
			}
		}
		System.out.println(result);
		
	}
}

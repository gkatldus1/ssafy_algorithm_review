package com.ssafy.review0131;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BJ_1439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int zero_cnt = 0;
		int one_cnt = 0;
		
		if(input.charAt(0)=='0')	one_cnt++;
		else	zero_cnt++;
		
		for(int i=0; i<input.length()-1; i++) {
			if(input.charAt(i)!=input.charAt(i+1)) {
				if(input.charAt(i+1)=='0')	one_cnt++;
				else	zero_cnt++;
			}
		}
		
		
		System.out.println(Math.min(zero_cnt, one_cnt));
	}
}

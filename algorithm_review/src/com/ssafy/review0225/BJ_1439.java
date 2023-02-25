package com.ssafy.review0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1439 {
	static String str;
	static int count0 = 0;
	static int count1 = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
	
		if(str.charAt(0)=='0') count1=1;
		else	count0=1;
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i)!=str.charAt(i+1)) {
				if(str.charAt(i)==0) count1++;
				else	count0++;
			}
		}
		System.out.println(Math.min(count0, count1));
		
		
		
	}
}

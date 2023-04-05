package com.ssafy.review0405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1439 {
	public static String str;
	public static int count0 = 0;
	public static int count1 = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		if(str.charAt(0) == '1') count0+=1;
		else	count1+=1;
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				if(str.charAt(i+1) == '1') count0 += 1;
				else count1 += 1;
			}
		}
		System.out.println(Math.min(count0, count1));
		
	}
	
	
}

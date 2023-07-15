package com.ssafy.review0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int result = Integer.parseInt(input.substring(0,1));
		for(int i=1; i<input.length(); i++) {
			int now = Integer.parseInt(input.substring(i, i+1));
			if(now == 1 || now == 0 || result == 0 || result == 1) result += now;
			else result *= now;
			
		}
		
		System.out.println(result);
		
	}
}

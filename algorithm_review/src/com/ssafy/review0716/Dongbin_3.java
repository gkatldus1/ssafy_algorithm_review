package com.ssafy.review0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count0 = 0;
		int count1 = 0;
		
		if(input.charAt(0) == '0')	count1 += 1;
		else	count0 += 1;
		
		for(int i=0; i<input.length()-1; i++) {
			if(input.charAt(i)!=input.charAt(i+1)) {
				//다음 수에서 1로 바뀌는 경우
				if(input.charAt(i+1) == '1')	count0 += 1;
				//다음 수에서 0으로 바뀌는 경우
				else	count1 += 1;
			}
		}
		System.out.println(Math.min(count0, count1));
		
		
	}
}

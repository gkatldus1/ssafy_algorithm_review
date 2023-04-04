package com.ssafy.review0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// split 함수에 공백문자를 지정
		String[] strArray = input.split("");
		
		int result = Integer.parseInt(strArray[0]);
		for(int i=1; i<strArray.length; i++) {
			int now = Integer.parseInt(strArray[i]);
			if(result == 0 || result == 1 || now == 0 || now == 1) {
				result += now; 
			}
			else {
				result *= now;
			}
		}
		
		System.out.println(result);
	}
}

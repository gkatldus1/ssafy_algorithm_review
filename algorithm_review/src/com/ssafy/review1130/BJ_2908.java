package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2908 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		String inv_num1 = "";
		String inv_num2 = "";
		for(int i=num1.length()-1; i>=0; i--) {
			inv_num1 += num1.charAt(i);
		}
		for(int i=num2.length()-1; i>=0; i--) {
			inv_num2 += num2.charAt(i);
		}
		int first = Integer.parseInt(inv_num1);
		int sec = Integer.parseInt(inv_num2);
		
		int big = Math.max(first, sec);
		System.out.println(big);
		
		
	}
}

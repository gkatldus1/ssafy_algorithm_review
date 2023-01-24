package com.ssafy.review1226;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = "I";
		int count = N;
		while(count-->0) {
			str+="O";
			str+="I";
		}
//		System.out.println(str);
		int M = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int cnt = 0;
		while(true) {
			int index = input.indexOf(str);
			if(index == -1) {
				break;
			}
			cnt++;
			int n_index = index+2;
			if(n_index<M-1) {
				String temp = input.substring(n_index);
				
				input = temp;
			}
			else {
				break;
			}
			M = input.length();
//			System.out.println(index+" "+input+" : "+M);
		}
		System.out.println(cnt);
		
	}
}

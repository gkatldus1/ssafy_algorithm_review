package com.ssafy.review1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ_1107 {

	static boolean[] buttons = new boolean[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String[] buttons = new String[M]; 
		StringTokenizer st = null;
		
		if(M!=0) {
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0; i<M; i++) {
			buttons[i] = st.nextToken();
		}
		
		int num = Integer.parseInt(N);
		int min = Math.abs(100-num);
		for(int i=0; i<=999999; i++) {
			String str = String.valueOf(i);
			boolean flag = false;
			for(int j=0; j<M; j++) {
				if(str.contains(buttons[j])) {
					flag = true;
					break;
				}
			}
			if(flag)	continue;
			int val = Math.abs(i-num) + str.length();
			if(val<min) {
				min = val;
			}
			
		}
		System.out.println(min);
		
		
		
		
	}

}

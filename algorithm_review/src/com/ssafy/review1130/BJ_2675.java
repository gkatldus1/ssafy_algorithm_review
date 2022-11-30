package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int l=0; l<loop; l++) {
			String str = "";
			st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			for(int i=0; i<input.length(); i++) {
				for(int j=0; j<repeat; j++) {
					str += input.charAt(i);
				}
			}
			System.out.println(str);
			
		}
		
		
		
	}
}

package com.ssafy.review1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759복습 {
	static String vo = "aeiou";
	static char[] selected;
	static char[] chars;
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	static int vo_cnt1 = 1;
	static int consonant_cnt1 = 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		selected = new char[L];
		chars = new char[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++)
			chars[i] = st.nextToken().charAt(0);
		Arrays.sort(chars);
		
		combination(0,0);
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == L) {
			if(isValid()) {
				sb.append(String.valueOf(selected)+"\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			selected[cnt] = chars[i];
			combination(cnt+1, i+1);
		}
		
	}
	
	static boolean isValid() {
		int vo_cnt = 0;
		int consonant_cnt = 0;
		for(char ch: selected) {
			if(vo.contains(ch+"")) vo_cnt++;
			else	consonant_cnt++;
		}
		if(vo_cnt>=vo_cnt1 && consonant_cnt>=2)	return true;
		else return false;
		
	}
	
	
	
}

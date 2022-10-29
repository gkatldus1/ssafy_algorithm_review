package com.ssafy.review1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759복습 {
	static char[] selected;
	static char[] chars;
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static String vo = "aeiou";
	static int vo_cnt = 1;
	static int consonant_cnt = 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		selected = new char[L];
		chars = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
//		System.out.println(Arrays.toString(chars));
		Arrays.sort(chars);
		combination(0,0);
		System.out.println(sb);
	}
	static void combination(int cnt,int start ) {
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
		int vo_num = 0;
		int con_num = 0;
		
		for(char ch: selected) {
			if(vo.contains(ch+""))	vo_num++;
			else	con_num++;
		}
		if(con_num>=consonant_cnt && vo_num >= vo_cnt)	return true;
		else return false;
	}
	
}

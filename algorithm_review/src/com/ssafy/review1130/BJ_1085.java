package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1085 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		//x축으로 최솟값 구해보기
		min = Math.min(min, x);
		min = Math.min(min, Math.abs(w-x));
		//y축으로 최솟값 구해보기
		min = Math.min(min, y);
		min = Math.min(min,  Math.abs(h-y));
		
		System.out.println(min);
		
	}
}

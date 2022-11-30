package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean asc = true;
		boolean desc = true;
		int[] arr1 = new int[9];
		int[] arr2 = new int[9];
		for(int i=1; i<=8; i++) {
			arr1[i] = i;
			arr2[i] = 9-i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=8; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now!=arr1[i]) {
				asc = false;
			}
			if(now!=arr2[i]) {
				desc = false;
			}
		}
		if(asc) {
			System.out.println("ascending");
			System.exit(0);
		}
		if(desc) {
			System.out.println("descending");
			System.exit(0);
		}
		System.out.println("mixed");
		
		
	}
}

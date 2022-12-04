package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10250 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] hotel = new int[100][100];
		for(int i=1; i<=99; i++) {
			for(int j=1; j<=99; j++) {
				hotel[i][j] = 100*i+j;
			}
		}
		
//		for(int i=1; i<=99; i++) {
//			System.out.println(Arrays.toString(hotel[i]));
//		}
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int loop=0; loop<T; loop++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int column = N/H + 1;
			int row = N%H;
			if(row==0) {
				row = H;
				column = N/H;
			}
			
			System.out.println(hotel[row][column]);
		}
		
		
	}
}

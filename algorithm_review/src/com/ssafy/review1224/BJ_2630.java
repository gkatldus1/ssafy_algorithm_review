package com.ssafy.review1224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2630 {
	static int[][] paper;
	static int blue;
	static int white;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
//		for(int[] arr : paper) {
//			System.out.println(Arrays.toString(arr));
//		}
		sep(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void sep(int r, int c, int size) {
		if(isPossible(r, c, size))	return;
		
		int n_size = size/2;
		
		sep(r,c, n_size); sep(r,c+n_size,n_size);
		sep(r+n_size, c, n_size); sep(r+n_size, c+n_size, n_size);
		
	}
	
	
	
	
	static boolean isPossible(int r, int c, int size) {
		int val = paper[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(paper[i][j]!=val)	return false;
			}
		}
		if(val == 1)	blue++;
		else	white++;
		return true;
		
		
	}
}

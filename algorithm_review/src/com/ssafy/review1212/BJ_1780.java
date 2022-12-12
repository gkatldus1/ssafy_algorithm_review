package com.ssafy.review1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780 {
	static int minusCount, zeroCount, oneCount;
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		district(0, 0, N);
		System.out.println(minusCount);
		System.out.println(zeroCount);
		System.out.println(oneCount);
		
	}
	static void district(int r, int c, int size) {
		if(isPossible(r, c, size))	return;
		
		int next = size/3;
		
		district(r, c, next); district(r, c+next, next); district(r, c+(next*2), next);
		district(r+next, c, next); district(r+next, c+next, next); district(r+next, c+(next*2), next);
		district(r+(2*next), c, next); district(r+(2*next), c+next, next); district(r+(2*next), c+(next*2), next);
		
		
		
		
	}
	static boolean isPossible(int r, int c, int size) {
		int num = paper[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(num != paper[i][j])
					return false;
			}
		}
		if(num == -1)	minusCount++;
		if(num == 0)	zeroCount++;
		if(num == 1)	oneCount++;
		return true;
	}
	
	
}

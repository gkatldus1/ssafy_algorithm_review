package com.ssafy.review1201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018 {
	
	static int min;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		 map = new char[N][M];
		
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j); 
			}
		}
		
		int N_row = N-7;
		int M_col = M-7;
		for(int i=0; i<N_row; i++) {
			for(int j=0; j<M_col; j++) {
				find(i,j);
			}
		}
		
		System.out.println(min);
		
	}
	
	static void find(int r, int c) {
		int end_r = r+8;
		int end_c = c+8;
		
		int count = 0;
		char check = map[r][c];
		
		for(int i=r; i<end_r; i++) {
			for(int j=c; j<end_c; j++) {
				
				//올바른 색이 아닐경우 1 증가
				if(map[i][j]!=check) {
					count++;
				}
				
				//색 변경
				if(check == 'W') check = 'B';
				else			 check = 'W';
				
			}
			//줄이 바뀔 시 마지막 색 그대로 내려옴으로 한번 더 바꿔서 원상 복귀
			if(check == 'W') check = 'B';
			else			 check = 'W';
		}
		
		//처음이 'B'때나 'W'를 비교해서 더 작은 것으로 바꿔준다.
		int temp_min = Math.min(count, 64-count);
		//전체 최솟값을 갱신시켜준다.
		min = Math.min(temp_min, min);
		
		
	}
	
}

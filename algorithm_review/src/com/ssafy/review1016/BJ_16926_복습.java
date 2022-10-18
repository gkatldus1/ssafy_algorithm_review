package com.ssafy.review1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_복습 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int repeat = Math.min(N, M)/2;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<repeat; j++) {
				int temp = map[j][j];	//맨 마지막에 넣기 위해 따로 저장
				
				for(int k=j+1; k<M-j; k++)
					map[j][k-1] = map[j][k];
				for(int k=j+1; k<N-j; k++)
					map[k-1][M-1-j] = map[k][M-1-j];
				for(int k=M-2-j; k>=j; k--)
					map[N-1-j][k+1] = map[N-1-j][k];
				for(int k=N-2-j; k>=j; k--)
					map[k+1][j] = map[k][j];
				
				map[j+1][j] = temp;
			}
			
		}
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				System.out.print(map[j][k] + " ");
			}
			System.out.println();
		}
		
		
	}
}

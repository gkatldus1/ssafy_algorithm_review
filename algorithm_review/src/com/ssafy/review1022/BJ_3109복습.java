package com.ssafy.review1022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3109복습 {
	static char[][] map;
	static boolean[][] visited;
	static int R, C;
	static int count;
	static boolean flag;
	
	static int[][] deltas = {{-1,1}, {0,1},{1,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
//		for(char[] arr: map) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		for(int r=0; r<R; r++) {
			gasRobber(r, 0);
			flag = false;
		}
		System.out.println(count);
		
	}
	
	static void gasRobber(int r, int c) {
		
		visited[r][c] = true;
		if(c == C-1) {
			flag = true;
			count++;
			for(boolean[] arr : visited) {
				System.out.println(Arrays.toString(arr));
			}
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if( nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc] == 'x' || visited[nr][nc])
				continue;
			gasRobber(nr, nc);
			if(flag==true)
				return;
			
		}
	}
	
	
}

package com.ssafy.review1223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	static int[][] map;
	static int N, M;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}; 
	static int cnt = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
//		for(int[] arr : map) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		BFS(0,0);
		System.out.println(cnt);
		
	}
	
	static void BFS(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			while(size-->0) {
				int[] cur = queue.poll();
				
				if(cur[0] == N-1 && cur[1] == M-1)	return;
				
				for(int i=0; i<dir.length; i++) {
					int nr = cur[0] + dir[i][0];
					int nc = cur[1] + dir[i][1];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M)	continue;
					if(map[nr][nc] == 0)	continue;
					if(visited[nr][nc])	continue;
					
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
					
				}
				
			}
		}
	}
}

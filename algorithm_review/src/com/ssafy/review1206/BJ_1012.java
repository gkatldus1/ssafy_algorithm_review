package com.ssafy.review1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {
	static int[][] field;
	static boolean[][] visited;
	static int count;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int l=0; l<T; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				field[r][c] = 1;
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(field[r][c] == 1 && !visited[r][c]) {
						count++;
//						BFS(r,c);
						DFS(r,c);
					}
				}
			}
			System.out.println(count);
		}
		
	}
	static void BFS(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<deltas.length; i++) {
				int n_r = now[0] + deltas[i][0];
				int n_c = now[1] + deltas[i][1];
				if(n_r<0 || n_r>=N || n_c<0 || n_c>=M || field[n_r][n_c]==0)	continue;
				if(visited[n_r][n_c])	continue;
				
				visited[n_r][n_c] = true;
				queue.offer(new int[] {n_r, n_c});
				
			}
			
		}
	}
	
	
	static void DFS(int r, int c) {
		visited[r][c] = true;
		for(int i=0; i<deltas.length; i++) {
			int n_r = r+deltas[i][0];
			int n_c = c+deltas[i][1];
			
			if(n_r<0 || n_r>=N || n_c<0 || n_c>=M || field[n_r][n_c] == 0)	continue;
			if(visited[n_r][n_c])	continue;
			DFS(n_r,n_c);
			
		}
	}
	
}

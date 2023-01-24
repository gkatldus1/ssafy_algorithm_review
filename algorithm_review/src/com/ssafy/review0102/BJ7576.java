package com.ssafy.review0102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static Queue<int[]> queue = new ArrayDeque<>();
	
	static int N, M;
	static int[][] map;
	static int day;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visited;
	static int t_num;
	static int t_cnt;
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		boolean flag = false;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)	queue.offer(new int[] {i, j});
				if(map[i][j] == 0) {
					flag = true;
					t_num++;
				}
			}
		}
		if(!flag) {//처음부터 전부 익어있으면
			System.out.println(0);
			return;
		}
		BFS();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		
		System.out.println(day);
		
		
	}
	
	static void BFS() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- >0) {
				
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			visited[r][c] = true;
			
			for(int i=0; i<4; i++) {
				int nr = r+deltas[i][0];
				int nc = c+deltas[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || map[nr][nc] == -1 || map[nr][nc] == 1)	continue;
				
				t_cnt++;
				map[nr][nc] = 1;
				queue.offer(new int[] {nr,nc});
				
				}
			}
			day++;
			if(t_cnt == t_num)	break;
		}
	}
	
	
}

package com.ssafy.review0129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	
	static String[][] map;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = input[j];
			}
		}
		
		BFS(N, M);
		System.out.println(cnt);
		
	}
	
	static void BFS(int N, int M) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		queue.offer(new int[] {0,0});	
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			while(size-->0) {
				int[] now = queue.poll();
				
				if(now[0] == N-1 && now[1] == M-1)	return;
				
				for(int i=0; i<deltas.length; i++) {
					int nr = now[0] + deltas[i][0];
					int nc = now[1] + deltas[i][1];
					
					if(nr<0 || nr>= N || nc<0 ||nc>=M)	 continue;
					if(map[nr][nc].equals("0"))	continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
						
				}
				
			}
			
			
			
			
			
		}
		
		
	}
	
}

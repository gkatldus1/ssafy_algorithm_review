package com.ssafy.review1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1194_복습 {
	static int N, M;
	static char[][] map;
	static int minMove;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static class Minsik{
		int r, c, depth;
		int keys;
		
		public void updateKeys(char key) {
			keys |= (1<<key-'a');
		}
		public boolean hasKey(char key) {
			return (keys & 1<<key-'A') >0;
		}
		public Minsik(int r, int c, int depth, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.keys = keys;
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Minsik start = null;
		map = new char[N][M];
		for(int r=0; r<N; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c=0; c<M; c++) {
				if(map[r][c] == '0')	start = new Minsik(r,c,0,0);
		}
	}
		minMove = Integer.MAX_VALUE;
		
		bfs(start);
		System.out.println(minMove==Integer.MAX_VALUE? -1: minMove);
	}
	
	static void bfs(Minsik start) {
		boolean[][][] visited = new boolean[N][M][1<<6];
		Queue<Minsik> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.r][start.c][start.keys] = true;
		
		while(!queue.isEmpty()) {
			Minsik front = queue.poll();
			
			if(map[front.r][front.c] == '1') {
				minMove = front.depth;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = front.r + deltas[i][0];
				int nc = front.c + deltas[i][1];
				int keys = front.keys;
				if(nr<0 || nr>= N || nc<0 || nc>=M || map[nr][nc] == '#' || visited[nr][nc][keys] )	continue;
				
				//문이라면 열쇠 판별 후 없다면 돌아가
				if(map[nr][nc]>='A' && map[nr][nc]<='Z' && !front.hasKey(map[nr][nc]))	continue;
				
				visited[nr][nc][keys] = true;
				Minsik newMinsik = new Minsik(nr,nc,front.depth+1, keys);
				if(map[nr][nc]>='a' && map[nr][nc] <='z') newMinsik.updateKeys(map[nr][nc]);
				
				queue.offer(newMinsik);				
			}
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

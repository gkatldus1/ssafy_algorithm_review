package com.ssafy.review1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_복습 {
	static int[][] deltas_m = {{1,0},{-1,0},{0,-1},{0,1}};
	static int[][] deltas_h = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	static int K;
	static int R, C;
	static int[][] map;
	static int minValue;
	static class Monkey{
		int r,c;
		int depth;
		int k;
		public Monkey(int r, int c, int depth, int k) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.k = k;
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st =  new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		minValue = Integer.MAX_VALUE;
		bfs();
		System.out.println(minValue==Integer.MAX_VALUE ? -1: minValue );
	}
	static void bfs() {
		boolean[][][] visited = new boolean[R][C][K+1];
		Queue<Monkey> q = new LinkedList<>();
		Monkey start = new Monkey(0,0,0,0);
		visited[0][0][0] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			Monkey front = q.poll();
			
			if(front.r==R-1 && front.c == C-1) {
				minValue = front.depth;
				return;	//목적지에 도착했으면 함수 끝
			}
			
			//원숭이처럼 가기
			monkeyMove(q, visited, front);
			//말처럼 가기
			if(front.k <K) {
				horseMove(q, visited, front);
			}
			
		}
		
		
	}
	static void monkeyMove(Queue q, boolean[][][] visited, Monkey front) {
		for(int i=0; i<deltas_m.length; i++) {
			int nr = front.r + deltas_m[i][0];
			int nc = front.c + deltas_m[i][1];
			
			if(!isIn(nr, nc) || map[nr][nc] == 1 )	continue;
			
			if(visited[nr][nc][front.k])	continue;
			
			visited[nr][nc][front.k] = true;
			Monkey m = new Monkey(nr, nc, front.depth+1, front.k);
			q.offer(m);
			
		}
	}
	
	static void horseMove(Queue q, boolean[][][] visited, Monkey front) {
		for(int i=0; i<deltas_h.length; i++) {
			int nr = front.r + deltas_h[i][0];
			int nc = front.c + deltas_h[i][1];
			
			if(!isIn(nr,nc) || map[nr][nc] == 1)	continue;
			if(visited[nr][nc][front.k+1])	continue;
			
			visited[nr][nc][front.k+1] = true;
			Monkey m = new Monkey(nr, nc, front.depth+1, front.k+1 );
			q.offer(m);
		}
	}
	
	
	
	
	
	
	static boolean isIn(int r, int c) {
		return (0<=r && r<R && 0<=c && c<C);
	}
	
	
	
	
}

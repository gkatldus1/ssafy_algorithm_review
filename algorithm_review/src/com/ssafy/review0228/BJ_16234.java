package com.ssafy.review0228;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BJ_16234 {
	
	static class Position{
		private int x;
		private int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
	}
	
	static int n, l, r;
	static int totalCount = 0;
	
	static int[][] graph = new int[50][50];
	static int[][] unions = new int[50][50];
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static void process(int x, int y, int index) {
		ArrayList<Position> united = new ArrayList<>();//BFS로 탐색할때 서로 연합하는 나라들
		Position start = new Position(x, y);
		united.add(start);
		
		Queue<Position> q = new LinkedList<>();
		q.offer(start);
		unions[x][y] = index;
		int summary = graph[x][y];
		int count = 1;
		
		while(!q.isEmpty()) {
			Position pos = q.poll();
			x = pos.getX();
			y = pos.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
					int gap = Math.abs(graph[nx][ny] - graph[x][y]);
					if(l <= gap && gap <= r) {
						q.offer(new Position(nx, ny));
						unions[nx][ny] = index;
						summary += graph[nx][ny];		
						count += 1;
						united.add(new Position(nx, ny));
					}
				}
			}
		}
		for(int i=0; i<united.size(); i++) {
			x = united.get(i).getX();
			y = united.get(i).getY();
			graph[x][y] = summary / count;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					unions[i][j] = -1;
				}
			}
			int index = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(unions[i][j] == -1) {
						process(i, j, index);
						index += 1;
					}
				}
			}
			if(index == n*n)	break;
			totalCount += 1;
		}
		System.out.println(totalCount);
		
	}
}

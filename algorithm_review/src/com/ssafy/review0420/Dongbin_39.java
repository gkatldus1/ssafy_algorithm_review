package com.ssafy.review0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_39 {
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int distance;
		
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public int getDistance() {
			return this.distance;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.distance, other.distance);
		}
	}
	
	public static final int INF = (int) 1e9;
	public static int[][] graph = new int[125][125];
	public static int[][] d = new int[125][125];
	public static int testCase, n;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		for(int tc=0; tc<testCase; tc++) {
			n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				Arrays.fill(d[i], INF);
			}
			
			int x=0, y=0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				if(d[x][y] < dist) continue;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || nx>=n || ny<0 || ny >=n)	continue;
					int cost = dist+graph[nx][ny];
					
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			System.out.println(d[n-1][n-1]);
			
		}
		
	}
	
}

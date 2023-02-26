package com.ssafy.review0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18405 {
	static class Virus implements Comparable<Virus>{
		
		private int index;
		private int second;
		private int x;
		private int y;
		
		public Virus(int index, int second, int x, int y) {
			this.index = index;
			this.second = second;
			this.x = x;
			this.y = y;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public int getSecond() {
			return this.second;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		@Override
		public int compareTo(Virus other) {
			return Integer.compare(this.index, other.getIndex());
		}
	}
	
	static int n, k;
	static int[][] graph = new int[200][200];
	static ArrayList<Virus> viruses = new ArrayList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] != 0) {
					viruses.add(new Virus(graph[i][j], 0, i, j));
				}
			}
		}
		
		Collections.sort(viruses);
		Queue<Virus> q = new LinkedList<>();
		for(int i=0; i<viruses.size(); i++) {
			q.offer(viruses.get(i));
		}
		
		st = new StringTokenizer(br.readLine());
		int targetS = Integer.parseInt(st.nextToken());
		int targetX = Integer.parseInt(st.nextToken());;
		int targetY  = Integer.parseInt(st.nextToken());
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			if(virus.getSecond() == targetS)	break;
			for(int i=0; i<4;i++) {
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				if(nx>=0 && nx < n && ny>=0 && ny < n) {
					if(graph[nx][ny] == 0) {
						graph[nx][ny] = virus.getIndex();
						q.offer(new Virus(virus.getIndex(), virus.getSecond()+1, nx, ny));
					}
				}
				
			}
		}
		
		System.out.println(graph[targetX-1][targetY-1]);
		
	}
}

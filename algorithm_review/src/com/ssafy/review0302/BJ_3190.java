package com.ssafy.review0302;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_3190 {
	static class Node{
		private int time;
		private char direction;
		
		public Node(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
		
		public int getTime() {
			return this.time;
		}
		
		public char getDirection() {
			return this.direction;
		}
	}
	
	static class Position{
		private int x, y;
		
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
	static int n, k, l;
	static int[][] arr = new int[101][101];
	static ArrayList<Node> info = new ArrayList<>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int turn(int direction, char c) {
		if(c=='L') direction = (direction==0) ? 3 : direction-1;
		else direction = (direction + 1) % 4;
		return direction;
	}
	
	static int simulate() {
		int x = 1, y = 1;
		arr[x][y] = 2;
		int direction = 0;
		int time = 0;
		int index = 0;
		
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			if(1<=nx && nx <=n && 1<=ny && ny <=n && arr[nx][ny] !=2) {
				if(arr[nx][ny] == 0) {
					arr[nx][ny] = 2;
					q.offer(new Position(nx,ny));
					Position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;
				}
				else {
					arr[nx][ny] = 2;
					q.offer(new Position(nx, ny));
				}
			}
			else {
				time += 1;
				break;
			}
			x = nx;
			y = ny;
			time += 1;
			if(index < l && time == info.get(index).getTime()) {
				direction = turn(direction, info.get(index).getDirection());
				index += 1;
			}
		}
		return time;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			info.add(new Node(x,c));
		}
		System.out.println(simulate());
	}
}

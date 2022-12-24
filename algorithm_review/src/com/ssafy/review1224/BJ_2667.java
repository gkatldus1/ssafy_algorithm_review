package com.ssafy.review1224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;

public class BJ_2667 {
	static class Group{
		int id;
		int cnt;
		public Group(int id, int cnt) {
			this.id = id;
			this.cnt = cnt;
		}
	}
	static int id;
	static ArrayList<Group> list = new ArrayList<>();
	static char[][] map;
	static boolean[][] visited;
	
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
//				if(!visited[i][j] && map[i][j] == '1')	BFS(i,j);
				if(!visited[i][j] && map[i][j] == '1') {
					list.add(new Group(id++, 1));
					int group = id - 1;
					DFS(i,j, group);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list, new Comparator<Group>() {

			@Override
			public int compare(Group o1, Group o2) {
				return o1.cnt - o2.cnt;
			}
		});
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).cnt);
		}
		
	}
	
	static void BFS(int r, int c) {
		Queue<int[]> queue  = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		list.add(new Group(id++, 1));
		
		while(!queue.isEmpty()) {
			int group = id - 1;
			int[] now = queue.poll();
			
			for(int i=0; i<deltas.length; i++) {
				int n_r = now[0] + deltas[i][0];
				int n_c = now[1] + deltas[i][1];
				
				if(n_r<0 || n_r>=N || n_c<0 || n_c>=N)	continue;
				if(map[n_r][n_c] == '0')	continue;
				if(visited[n_r][n_c])	continue;
				
				visited[n_r][n_c] = true;
				queue.offer(new int[] {n_r, n_c});
				list.get(group).cnt++;

			}
		}
	}
	
	static void DFS(int r, int c, int group) {
		visited[r][c] = true;
		
		for(int i=0; i<deltas.length; i++) {
			int n_r = r+deltas[i][0];
			int n_c = c+deltas[i][1];
			
			if(n_r<0 || n_r>=N || n_c<0 || n_c>=N)	continue;
			if(map[n_r][n_c] == '0')	continue;
			if(visited[n_r][n_c])	continue;
			
			visited[n_r][n_c] = true;
			list.get(group).cnt++;
			DFS(n_r, n_c, group);
		}
	}
	
}

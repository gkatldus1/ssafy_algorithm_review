package com.ssafy.review1224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2606 {
	static boolean[] visited;
	static ArrayList[] net;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		net = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			net[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			net[node1].add(node2);
			net[node2].add(node1);
			
		}
		
//		for(int i=1; i<=N; i++) {
//			if(!visited[i])	DFS(i);
//		}
		visited[1] = true;
		DFS(1);
		System.out.println(cnt);
	}
	
	static void DFS(int cur) {
		for(int i=0; i<net[cur].size(); i++) {
			int now = (int)net[cur].get(i);
			if(visited[now])  continue;
			cnt++;
			visited[now] = true;
			DFS(now);
			
		}
	}
	
	
	
}

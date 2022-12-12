package com.ssafy.review1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {
	static ArrayList[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start].add(end);
			arr[end].add(start);
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(arr[i]);
		}
		dfs(new boolean[N+1], V);
		System.out.println();
		bfs(new boolean[N+1], V);
	}
	static void dfs(boolean[] visited, int cur) {
		visited[cur] = true;
		System.out.print(cur+" ");
		for(int i=0; i<arr[cur].size(); i++) {
			int now = (int)arr[cur].get(i);
			if(visited[now])	continue;
			dfs(visited, now);
			
		}
	}
	
	static void bfs(boolean[] visited, int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		visited[start] = true;
		queue.offer(start);
//		System.out.print(start+" ");
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now+" ");
			for(int i=0; i<arr[now].size(); i++) {
				int cur = (int)arr[now].get(i);
				if(visited[cur]) continue;
				visited[cur] = true;
				queue.add(cur);
				
			}
			
		}
		
		
	}
	
}

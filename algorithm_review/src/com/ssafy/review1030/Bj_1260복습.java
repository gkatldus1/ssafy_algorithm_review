package com.ssafy.review1030;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Bj_1260복습 {
	
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int V = sc.nextInt();
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i=1; i<=N; i++)
			Collections.sort(graph[i]);
		
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
		
	}
	
	static void DFS(int start) {
		System.out.print(start+" ");
		visited[start] = true;
		for(int i : graph[start]) {
			if(visited[i])
				continue;
			DFS(i);
		}
	}
	
	static void BFS(int start) {
//		System.out.print(start+" ");
		visited[start] = true;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur+" ");
			for(int i : graph[cur]) {
				if(visited[i])	continue;
				visited[i] = true;
				queue.offer(i);
			}
			
		}
		
	}
	
	
	
}

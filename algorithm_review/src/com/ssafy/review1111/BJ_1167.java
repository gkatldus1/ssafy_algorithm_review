package com.ssafy.review1111;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_1167{
	
	static int node;
	static int max;
	static ArrayList<Edge>[] list;
	static boolean[] visited;
	static int[] distance;
	static class Edge{
		int e;
		int value;
		public Edge(int e, int value) {
			this.e = e;
			this.value= value;
		
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<V; i++) {
			int s = sc.nextInt();
			while(true) {
				int e = sc.nextInt();
				if(e == -1)	break;
				int value = sc.nextInt();
				list[s].add(new Edge(e, value));
				
			}
		}
		visited = new boolean[V+1];
		DFS(1, 0);
		visited = new boolean[V+1];
		max = 0;
		DFS(node, 0);
		System.out.println(max);
		
		
	}
	
	static void DFS(int x, int len ) {
		if(len > max) {
			max = len;
			node = x;
		}
		visited[x] = true;
		for(int i=0; i<list[x].size(); i++) {
			Edge ele = list[x].get(i);
			if(visited[ele.e])	continue;
			DFS(ele.e, len+ele.value);
//			visited[ele.e] = true;
			
		}
		
		
	}
	
	
	
	
	static void BFS(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			
			for(Edge i: list[now_node]) {
				int e = i.e;
				int value = i.value;
				
				if(visited[e])	continue;
				
				visited[e] = true;
				
				queue.offer(e);
				distance[e] = distance[now_node] + value;
				
			}
			
		}
		
	}
	
}

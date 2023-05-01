package com.ssafy.review0501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_43 {
	static class Edge implements Comparable<Edge>{
		
		private int distance;
		private int nodeA;
		private int nodeB;
		
		public Edge(int distance, int nodeA, int nodeB) {
			this.distance = distance;
			this.nodeA = nodeA;
			this.nodeB = nodeB;
		}
		
		public int getDistance() {
			return this.distance;
		}
		
		public int getNodeA() {
			return this.nodeA;
		}
		
		public int getNodeB() {
			return this.nodeB;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.distance, other.getDistance());
		}
	}
	
	static int n, m;
	static int[] parent = new int[200001];
	static ArrayList<Edge> edges = new ArrayList<>();
	static int result = 0;
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)	parent[b] = a;
		else 	parent[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			edges.add(new Edge(z,x,y));
		}
		
		Collections.sort(edges);
		int total = 0;
		
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b= edges.get(i).getNodeB();
			total += cost;
			if(findParent(a)!=findParent(b)) {
				unionParent(a,b);
				result += cost;
			}
		}
		System.out.println(total - result);
		
	}
	
}

package com.ssafy.review0320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_40 {
	static class Node implements Comparable<Node>{
		private int index;
		private int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int getIndex() {
			return this.index;
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
	public static int n, m;
	public static int start = 1;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	public static int[] d = new int[20001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist)	continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, 1));
			graph.get(b).add(new Node(a, 1));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		int maxNode = 0;
		int maxDistance = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(maxDistance <d[i]) {
				maxNode = i;
				maxDistance = d[i];
				result.clear();
				result.add(maxNode);
			}
			else if(maxDistance == d[i]) {
				result.add(i);
			}
		}
		
		System.out.println(maxNode + " " + maxDistance + " " + result.size());
		
	}
	
	
	
	
	
	
	
	
}

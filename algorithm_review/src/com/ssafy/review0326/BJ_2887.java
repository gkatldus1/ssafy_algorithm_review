package com.ssafy.review0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2887 {
	
	static int[] parent = new int[100001];
	static int N;
	
	static class Position implements Comparable<Position>{
		private int x;
	    private int y;

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

	    // x가 거리, y가 번호 => 거리가 같다면 번호가 낮은 순으로 정렬
	    @Override
	    public int compareTo(Position other) {
	        if (this.x == other.x) {
	            return Integer.compare(this.y, other.y);
	        }
	        return Integer.compare(this.x, other.x);
	    }
	}
	
	
	
	static class Edge implements Comparable<Edge>{
		int distance;
		int nodeA;
		int nodeB;
		
		public Edge(int distance, int nodeA, int nodeB) {
			this.distance = distance;
			this.nodeA = nodeA;
			this.nodeB = nodeB;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.distance, other.distance);
		}
		
	}
	
	static int findParent(int a) {
		if(parent[a] == a)	return a;
		return parent[a] = findParent(parent[a]);
	}
	
	static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a<b)	parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		ArrayList<Position> x = new ArrayList<>();
		ArrayList<Position> y = new ArrayList<>();
		ArrayList<Position> z = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			x.add(new Position(a, i));
			y.add(new Position(b, i));
			z.add(new Position(c, i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(x.get(i + 1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i + 1).getY()));
            edges.add(new Edge(y.get(i + 1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i + 1).getY()));
            edges.add(new Edge(z.get(i + 1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i + 1).getY()));
        }
		
		Collections.sort(edges);
		int result = 0;
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).distance;
			int a = edges.get(i).nodeA;
			int b = edges.get(i).nodeB;
			
			if(findParent(a)!=findParent(b)) {
				unionParent(a,b);
				result += cost;
			}
			
		}
		System.out.println(result);
		
	}
	
	
	
}

package com.ssafy.review0709;

import java.util.*;

public class Dongbin_44 {
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
			 if(this.distance < other.distance)
				 return -1;
			 return 1;
		 }
	}
	
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
	    
	    @Override
	    public int compareTo(Position other) {
	    	if(this.x == other.x) {
	    		return Integer.compare(this.y, other.y);
	    	}
	    	return Integer.compare(this.x, other.x);
	    }
	}
	
	
	public static int n;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)	parent[b] = a;
		else	parent[a] = b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		ArrayList<Position> x = new ArrayList<>();
		ArrayList<Position> y = new ArrayList<>();
		ArrayList<Position> z = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			x.add(new Position(a, i));
			y.add(new Position(b, i));
			z.add(new Position(c, i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		 // 인접한 노드들로부터 간선 정보를 추출하여 처리
        for (int i = 0; i < n - 1; i++) {
            edges.add(new Edge(x.get(i + 1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i + 1).getY()));
            edges.add(new Edge(y.get(i + 1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i + 1).getY()));
            edges.add(new Edge(z.get(i + 1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i + 1).getY()));
        }
        
        Collections.sort(edges);
        
        for(int i=0; i<edges.size(); i++) {
        	int cost = edges.get(i).getDistance();
        	int a= edges.get(i).getNodeA();
        	int b= edges.get(i).getNodeB();
        	
        	if(findParent(a) != findParent(b)) {
        		unionParent(a,b);
        		result += cost;
        	}
        }
		System.out.println(result);
		
		
	}
}

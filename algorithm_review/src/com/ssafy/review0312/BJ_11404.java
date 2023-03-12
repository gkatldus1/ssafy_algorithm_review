package com.ssafy.review0312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11404 {
	static final int INF = (int) 1e9;
	static int n, m;
	static int[][] graph = new int[101][101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for(int i=1; i<101; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int a=1; a<=n; a++) {
			for(int b=1; b<=n; b++) {
				if(a==b)	graph[a][b] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(c<graph[a][b])graph[a][b] = c;
			
		}
		
		for(int k=1; k<=n; k++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					if(a==b)	continue;
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j] == INF) {
					System.out.print("0" + " ");
				}
				else {
					System.out.print(graph[i][j]+" ");
				}
			}
			System.out.println();
		}
		
		
	}
	
	
}

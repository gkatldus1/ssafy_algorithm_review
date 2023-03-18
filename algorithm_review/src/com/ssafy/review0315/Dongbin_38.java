package com.ssafy.review0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_38 {
	static final int INF = (int) 1e9;
	static int n, m;
	static int[][] graph = new int[501][501];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int a=1; a<=n; a++) {
			for(int b=1; b<=n; b++) {
				if(a==b) graph[a][b] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
		}
		
		for(int k=1; k<=n; k++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		int result = 0;
		for(int i=1; i<=n; i++) {
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				if(graph[i][j]!=INF || graph[j][i]!=INF) {
					cnt += 1;
				}
			}
			if(cnt == n) {
				result += 1;
			}
		}
		
		System.out.println(result);
		
	}
	
	
	
}

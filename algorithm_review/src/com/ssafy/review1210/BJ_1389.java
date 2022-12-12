package com.ssafy.review1210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1389 {
	static ArrayList[] arr;
	static int N,M;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);
		}
		int min = Integer.MAX_VALUE;
		int min_p = 0;
		for(int i=1; i<=N; i++) {
			int val = BFS(i);
//			System.out.println(val);
			if(min>val) {
				min = val;
				min_p = i;
			}
		}
		System.out.println(min_p);
		
	}
	
	
	
	static int BFS(int start) {
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[N+1];
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int cur = now[0];
			int count = now[1];
			cnt+=count;
			for(int i=0; i<arr[cur].size(); i++) {
				int point = (int)arr[cur].get(i);
				if(visited[point]) continue;
				
				visited[point] = true;
				queue.offer(new int[] {point, count+1});
				
				
			}
			
		}
		
		return cnt;
		
		
	} 
	
}

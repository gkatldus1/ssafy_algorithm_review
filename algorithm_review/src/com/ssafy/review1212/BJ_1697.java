package com.ssafy.review1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {
	static boolean[] visited = new boolean[100001]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = BFS(N, K);
		System.out.println(ans);
		
		
	}
	
	static int BFS(int N, int K) {
		if(N==K)	return 0;
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		int count = 0;
		int limit = N-K;
		visited[N] = true;
		queue.offer(N);
		while(!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for(int i=0; i<size; i++) {
				int now = queue.poll();
				
				int p1 = now-1;
				int p2 = now+1;
				int p3 = now*2;
				
				if(p1==K||p2==K||p3==K) {
					return count;
				}
				
				if(p1 >= 0 &&!visited[p1]) {	
					visited[p1] = true;
					queue.offer(p1);
				}
				
				if(p2<=100000 &&!visited[p2]) {
					visited[p2] = true;
					queue.offer(p2);
				}
				
				if(p3<=100000 &&!visited[p3]) {
					visited[p3] = true;
					queue.offer(p3);
				}
				
			}
			
		}
		
		return limit;
		
	}
	
	
}

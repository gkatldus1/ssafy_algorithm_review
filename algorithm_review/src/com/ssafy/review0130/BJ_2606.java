package com.ssafy.review0130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606 {
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
			
		}
		BFS(arr, N);
		System.out.println(cnt);
		
	}
	
	static void DFS(ArrayList<Integer>[] arr, int N) {
		
	}
	
	
	
	static void BFS(ArrayList<Integer>[] arr, int N) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int now = queue.poll();
				for(int i=0; i<arr[now].size(); i++) {
					int computer = arr[now].get(i);
					if(visited[computer])	continue;
//					System.out.println(computer);
					queue.offer(computer);
					visited[computer] = true;
					cnt++;
				}
					
				
			}
			
		}
		
	}
	
}

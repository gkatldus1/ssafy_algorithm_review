package com.ssafy.review0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18352 {
	
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer> ans = new ArrayList<>();
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++ ) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
		}
		BFS(X, K);
		if(ans.size()==0)	System.out.println(-1);
		Collections.sort(ans);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	static void BFS(int start, int len) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		int dis = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			dis++;
			while(size-->0) {
				int now = queue.poll();
				for(int i=0; i<arr[now].size(); i++) {
					if(visited[arr[now].get(i)])	continue;
					visited[arr[now].get(i)] = true;
					if(dis==len)	ans.add(arr[now].get(i));
					queue.offer(arr[now].get(i));
				}
			}
			if(dis==len)	return;
			
			
		}
		
	}
}

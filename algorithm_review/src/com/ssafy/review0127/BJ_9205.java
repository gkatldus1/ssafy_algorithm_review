package com.ssafy.review0127;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] arr = new ArrayList[n+2];
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<n+2; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			
			for(int i=0; i<n+2; i++) {	//좌표 전부 받음
				st = new StringTokenizer(br.readLine());
				int[] point = new int[2];
				
				point[0] = Integer.parseInt(st.nextToken());
				point[1] = Integer.parseInt(st.nextToken());
				
				list.add(point);
			}
			//받은 좌표들이 갈 수 있는 노드들을 그래프로 만든다.
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j) continue;
					
					int[] p1 = list.get(i);
					int[] p2 = list.get(j);
					
					if(distance(p1, p2)<=1000) {//20개 안에 있으면 연결해주기
						arr[i].add(j);
						arr[j].add(i);
					}
				}
			}
			
			sb.append(BFS(arr, 0, n)? "happy" : "sad" ).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static boolean BFS(ArrayList<Integer>[] arr, int start, int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+2];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == n+1)	return true;
			
			for(int i=0; i<arr[now].size(); i++) {
				int next = arr[now].get(i);
				if(visited[next])	continue;
				visited[next] = true;
				queue.offer(next);
				
			}
		}
		
		return false;
	}
	
	
	static int distance(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
	
}

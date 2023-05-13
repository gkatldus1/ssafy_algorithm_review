package com.ssafy.review0513;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18352 {
	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] d = new int[300001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		x = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		d[x] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				if(d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		if(!check) System.out.println(-1);
	}
	
	
}

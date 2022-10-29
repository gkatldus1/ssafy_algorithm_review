package com.ssafy.review1029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_13023복습 {
	static boolean[] visited;
	static ArrayList<Integer>[] A; 
	static boolean arrive;
	
	public static void main(String[] args) {
		int N;
		int M;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=-0; i<N; i++)
			A[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			A[a].add(b);
			A[b].add(a);
		}
		
//		System.out.println(Arrays.toString(A));
		
		
		for(int i=0; i<N; i++) {
			DFS(i, 0);
			if(arrive)
				break;
		}
		
		System.out.println(arrive ? "1" : "0");
		
	}
	
	static void DFS(int now, int depth) {
		if(depth == 4 || arrive) {
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i: A[now]) {
			if(!visited[i]) {
				DFS(i, depth + 1);
			}
			if(arrive)	return;
		}
		visited[now] = false;
	}
	
}

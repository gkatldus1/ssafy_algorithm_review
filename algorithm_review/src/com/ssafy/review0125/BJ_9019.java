package com.ssafy.review0125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_9019 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<>();
			String[] command = new String[10000];
			boolean[] visited = new boolean[10000];
			visited[A] = true;
			Arrays.fill(command, "");
			queue.offer(A);
			while(!queue.isEmpty() && !visited[B]) {
				int now = queue.poll();
				int D = (2*now)%10000;
				int S = (now==0)? 9999:now-1;
				int L = (now%1000)*10 + now/1000;
				int R = (now%10)*1000 + now/10;
				
				if(!visited[D]) {
					visited[D] = true;
					command[D] = command[now] + "D";
					queue.offer(D);
				}
				if(!visited[S]) {
					visited[S] = true;
					command[S] = command[now] + "S";
					queue.offer(S);
				}
				if(!visited[L]) {
					visited[L] = true;
					command[L] = command[now] + "L";
					queue.offer(L);
				}
				if(!visited[R]) {
					visited[R] = true;
					command[R] = command[now] + "R";
					queue.offer(R);
				}
			}
			System.out.println(command[B]);
			
		}
		
		
	}
}

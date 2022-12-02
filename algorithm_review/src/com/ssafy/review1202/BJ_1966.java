package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1966 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<int[]> queue;
		for(int loop=0; loop<T; loop++) {
			queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			
			
			for(int i=0; i<N; i++) {
				int value = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {value,i});
			}
			int count = 1;
			while(!queue.isEmpty()) {
				int[] front = queue.poll();
				
				
				boolean max = true;
				for(int i=0; i<queue.size(); i++) {
					if(front[0]<queue.get(i)[0]) {
						max = false;
						break;
					}
				}
				
				if(max) {
					if(M==front[1]) {
						System.out.println(count);
						break;
					}
					else {
						count++;
					}
				}
				else {
					queue.offer(front);
				}
				
				
				
			}
		}
		
	}
}

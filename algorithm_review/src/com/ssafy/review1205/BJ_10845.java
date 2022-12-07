package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_10845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
//		System.out.println("pqsize:"+pq.size());
		for(int i=0; i<N; i++) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb);
		
	}
}

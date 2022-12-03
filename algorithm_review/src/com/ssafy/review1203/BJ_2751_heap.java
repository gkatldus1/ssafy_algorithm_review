package com.ssafy.review1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_2751_heap {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			heap.add(Integer.parseInt(br.readLine()));
		}
		for(int i=0; i<N; i++) {
			sb.append(heap.poll()).append("\n");
		}
		System.out.println(sb);
		
	}
}

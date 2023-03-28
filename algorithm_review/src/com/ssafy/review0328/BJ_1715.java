package com.ssafy.review0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class BJ_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int num = 0;
		int N = Integer.parseInt(br.readLine());


		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(pq.size()!=1) {
			int one = pq.poll();
			int two = pq.poll();
			
			int summary = one + two;
			result += summary;
			pq.offer(summary);
		}
		System.out.println(result);
		
	}
}

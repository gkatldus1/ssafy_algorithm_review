package com.ssafy.review0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class BJ_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		int result = 0;
		
		while(pq.size()!=1) {
			int one = pq.poll();
			int two = pq.poll();
			int sum = one + two;
			result += sum;
			pq.offer(sum);
		}
		System.out.println(result);
	}
}

package com.ssafy.review0528;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class BJ_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrList = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		while(pq.size()>1) {
			int first = pq.poll();
			int second = pq.poll();
			
			int temp = first + second;
			sum += temp;
			pq.offer(temp);
		}
		System.out.println(sum);
	}
}

package com.ssafy.review1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		Queue<Integer> queue = new ArrayDeque<Integer>();
		while(sub.hasMoreTokens()) {
			
			StringTokenizer plus = new StringTokenizer(sub.nextToken(), "+");
			int sum = 0;
			while(plus.hasMoreTokens()) {
				sum += Integer.parseInt(plus.nextToken());
			}
			queue.offer(sum);
			
		}
		int first = queue.poll();
		while(!queue.isEmpty()) {
			first -= queue.poll();
		}
		System.out.println(first);
		
		
	}
}

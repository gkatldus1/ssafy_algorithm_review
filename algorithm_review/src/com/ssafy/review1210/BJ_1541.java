package com.ssafy.review1210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0; i<str.length; i++) {
			String[] plus = str[i].split("\\+");
			int val = 0;
			for(int j=0; j<plus.length; j++) {
				val+=Integer.parseInt(plus[j]);
			}
			queue.offer(val);
			
		}
		int first = queue.poll();
		while(!queue.isEmpty()) {
			first -= queue.poll();
		}
		System.out.println(first);
		
	}
}

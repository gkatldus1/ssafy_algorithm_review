package com.ssafy.review1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String func = br.readLine();
			int N = Integer.parseInt(br.readLine());
			if(N==0) {
				String input = br.readLine();

				if(func.contains("D"))
					System.out.println("error");
				else {
					System.out.println("[]");
				}
				continue;
			}
			String input = br.readLine();
			int end = input.length()-1;
			input = input.substring(1, end);
//			System.out.println(input);
			String[] nums = input.split(",");
//			System.out.println(Arrays.toString(nums));
			Deque<Integer> deq = new ArrayDeque<>();
			
			for(int i=0; i<nums.length; i++) {
				int num = Integer.parseInt(nums[i]);
				deq.offer(num);
			}
			boolean isError = false;
			int flag = 1;
			for(int i=0; i<func.length(); i++) {
				char now = func.charAt(i);
				if(now == 'R') {
					flag *= -1;
				}
				else if(now == 'D') {
					if(deq.isEmpty()) {
						System.out.println("error");
						isError = true;
						break;
					}
					else if(flag == 1) {
						deq.poll();
					}
					else if(flag == -1) {
						deq.pollLast();
					}
					
				}
				
			}
			if(isError) continue;
			System.out.print("[");
			if(flag == -1) {
				while(!deq.isEmpty()) {
					if(deq.size()==1) {
						System.out.print(deq.poll());
					}
					else {
						System.out.print(deq.pollLast()+",");
						
					}
				}
			}
			else {
				while(!deq.isEmpty()) {
					if(deq.size()==1) {
						System.out.print(deq.poll());
					}
					else {
						System.out.print(deq.poll()+",");
						
					}
				}
			}
			
			System.out.println("]");
			
		}
		
		
	}
}

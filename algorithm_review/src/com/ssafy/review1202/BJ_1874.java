package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cur = 0;
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		while(n-->0) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > cur) {
				for(int i=cur+1; i<=value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				cur = value;
			}
			
			else if(stack.peek()!=value) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
			
		}
		System.out.println(sb);
	}
}

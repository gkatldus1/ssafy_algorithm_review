package com.ssafy.review1204;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_10773 {
	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for(int i=0; i<k; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
			
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			
			sum += stack.pop();
		}
		
		System.out.println(sum);
		
	}
}

package com.ssafy.review1203;

import java.util.Scanner;

public class BJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 7;
		int count = 2;
		
		int increment = 6;
		int last = 0;
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		while(true) {
			if(N<=start) {
				System.out.println(count);
				break;
			}
			increment += 6;
			start += increment;
			count++;
			
			
		}
		
	}
}

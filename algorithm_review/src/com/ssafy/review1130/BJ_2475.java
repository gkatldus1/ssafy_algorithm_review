package com.ssafy.review1130;

import java.util.Scanner;

public class BJ_2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			int temp = sc.nextInt();
			sum += Math.pow(temp, 2);
		}
		int ans = sum%10;
		System.out.println(ans);
		
	}
}

package com.ssafy.review1201;

import java.util.Scanner;

public class BJ_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i=666; i<Integer.MAX_VALUE; i++) {
			if(Integer.toString(i).contains("666"))	N--;
			if(N==0) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		
	}
}

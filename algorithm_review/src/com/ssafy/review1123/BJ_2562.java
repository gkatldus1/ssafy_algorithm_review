package com.ssafy.review1123;

import java.util.Scanner;

public class BJ_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>max) {
				max = arr[i];
				cnt = i;
			}
		}
		System.out.println(max);
		System.out.println(cnt+1);
		
	}
}

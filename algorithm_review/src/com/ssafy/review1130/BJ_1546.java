package com.ssafy.review1130;

import java.util.Scanner;

public class BJ_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		int max = Integer.MIN_VALUE;
		double sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		double ans = sum/max*100/N;
		System.out.println(ans);
		
		
	}
}

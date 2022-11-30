package com.ssafy.review1130;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] remain = new int[42];
		Arrays.fill(remain, 0);
		int index = 0;
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			index = num %42;
			if(remain[index] == 0) {
				remain[index] = 1;
			}
		}
		int ans = 0;
		for(int i=0; i<remain.length; i++) {
			ans += remain[i];
		}
		System.out.println(ans);
	}
}

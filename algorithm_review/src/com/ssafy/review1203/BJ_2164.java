package com.ssafy.review1203;

import java.util.Scanner;

public class BJ_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[2*N];
		
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		int prev_pointer = 1;
		int last_pointer = N;
				
		
		while(N-- >1) {
			prev_pointer++;
			arr[last_pointer+1] = arr[prev_pointer];
			prev_pointer++;
			last_pointer++;
			
		}
		System.out.println(arr[prev_pointer]);
		
	}
}

package com.ssafy.review1112;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++)
			nums[i] = sc.nextInt();
		Arrays.sort(nums);
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			int start = 0;
			int end = nums.length-1;
			boolean flag = false;
			while(start<=end) {
				int mid = (start + end)/2;
				if(nums[mid] == num) {
					System.out.println(1);
					flag = true;
					break;
				}
				else if(nums[mid]> num) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
				
				
			}
			if(!flag)
				System.out.println(0);
		}
		
	}
}

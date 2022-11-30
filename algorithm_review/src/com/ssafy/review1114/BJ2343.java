package com.ssafy.algorithm1114;

import java.util.Scanner;

public class BJ2343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr= new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int start = 0;	//이진 탐색의 시작은 가장 큰 원소
		int end = 0;	//이진 탐색의 끝은 모든 원소를 합한 값
		int mid = 0;
		for(int i=0; i<N; i++) {
			if(start < arr[i]) {
				start = arr[i];
			}
			end += arr[i];
		}
		
		while(start<=end) {
			mid = (start + end)/2;
			int sum = 0;
			int count = 0;	//사용되어야하는 블루레이의 개수
			for(int i=0; i<N; i++) {
				if(sum + arr[i] > mid) {
					sum = 0;
					count++;
				}
				sum += arr[i];
			}
			if(sum > 0)	count++;
			if(count > M) start = mid+1;
			if(count <= M) end = mid-1;	
		}
		System.out.println(start);
	}
}

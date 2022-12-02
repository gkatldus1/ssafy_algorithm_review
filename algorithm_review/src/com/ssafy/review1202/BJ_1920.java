package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
//			System.out.print(arr1[i] +" ");
		}
		Arrays.sort(arr1);
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
//			System.out.print(arr2[i] +" ");
		}
		
		
		for(int i=0; i<M; i++) {
			int start = 0;
			int last = N-1;
			boolean flag = false;
			while(start<=last) {
				int mid = (start+last)/2;
				
				if(arr1[mid] == arr2[i]) {
					flag = true;
					break;
				}
				else if(arr1[mid]>arr2[i]) {
					last = mid-1;
				}
				else {
					start = mid+1;
				}
				
			}
			if(flag)	System.out.println(1);
			else		System.out.println(0);
		}
		
		
		
		
	}
}

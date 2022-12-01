package com.ssafy.review1201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[K];
		long max = 0;
		
		for(int i=0; i<K; i++) {
			arr[i]  = Long.parseLong(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			
			mid = (max+min)/2;
			
			long count = 0;
			
			for(int i=0; i<arr.length; i++) {
				count += (arr[i]/mid);
			}
			
			
			if(count < N) {
				max = mid;
			}
			else {
				min = mid+1;
			}
			
			
		}
		
		System.out.println(min-1);
		
	}
}

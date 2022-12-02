package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		
		long max = 0;
		
		
		
		for(int i=0; i<K; i++) {
			arr[i]  = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		long min = 1;
		long mid = 0;
		
		while(max>=min) {
			mid = (max+min)/2;
			
			int count = 0;
			
			for(int i=0; i<K; i++) {
				count += (arr[i]/mid);
			}
			
			if(count >=N) {
				min = mid+1;
			}else {
				max = mid-1;
			}
			
			
		}
		System.out.println(max);
		
		
		
	}
}

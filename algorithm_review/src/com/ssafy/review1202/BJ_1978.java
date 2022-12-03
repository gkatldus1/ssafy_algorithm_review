package com.ssafy.review1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] == 1) {
				continue;
			}
			boolean flag = true;
			for(int j=2; j<=Math.sqrt(arr[i]); j++) {
				if(arr[i]%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag)	count++;
		}
		 
		System.out.println(count);
		
	}
}

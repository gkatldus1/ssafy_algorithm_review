package com.ssafy.review0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N-1;
		long temp = 99999;
		long diff = Long.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		while(start < end) {
			temp = arr[start] + arr[end];
			long abs = Math.abs(temp);
			if(abs<diff) {
				ans1 = arr[start];
				ans2 = arr[end];
				diff = abs;
			}
			
			if(temp == 0) {
				ans1 = arr[start];
				ans2 = arr[end];
				break;
			}
			else if(temp>0) {
				end--;
			}
			else if(temp<0) {
				start++;
			}
			
		}
		System.out.println(ans1+" "+ans2);
		
		
	}
}

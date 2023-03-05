package com.ssafy.review0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Dongbin_28 {
	static int binarySearch(int[] arr, int start, int end) {
		if(start > end)	return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == mid)	return mid;
		else if(arr[mid]>mid)	return binarySearch(arr, start, mid-1);
		else 	return binarySearch(arr, mid+1, end);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
	
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = binarySearch(arr, 0, arr.length);
		System.out.println(ans);
		
	}
	
}

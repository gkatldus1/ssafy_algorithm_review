package com.ssafy.review0331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_28 {

	public static int binarySearch(int[] arr, int start, int end) {
		if(start > end) return -1;
		
		int mid = (start + end) / 2;
		if(arr[mid] == mid) return mid;
		else if(arr[mid] > mid) return binarySearch(arr, start, mid-1);	
		else return binarySearch(arr, mid+1, end);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;  i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = binarySearch(arr, 0, n-1);
		System.out.println(index);
	}
	
}

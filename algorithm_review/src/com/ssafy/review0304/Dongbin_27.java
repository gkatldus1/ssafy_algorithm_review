package com.ssafy.review0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_27 {
	static int lowerBound(int[]arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) /2;
			if(arr[mid]>=target)	end = mid;
			else start = mid + 1;
		}
		return end;
	}
	static int upperBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) /2;
			if(arr[mid]>target)	end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	static int countByRange(int[] arr, int leftValue, int rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
		return rightIndex - leftIndex;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = countByRange(arr, x, x);
		
		if(ans == 0)	System.out.println(-1);
		else System.out.println(ans);
	}
	
	
}


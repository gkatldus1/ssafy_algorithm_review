package com.ssafy.review0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_27 {
	//가장 왼쪽에 있는 타겟 인덱스를 리턴
	public static int lowerBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] >= target) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	//가장 오른쪽 타겟보다 하나 더 오른쪽에 있는 인덱스 리턴
	public static int upperBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end)/2;
			if(arr[mid] > target) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0 , arr.length);
		return rightIndex - leftIndex;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = countByRange(arr, X, X);
		if(cnt == 0)	System.out.println(-1);
		else System.out.println(cnt);
	}
	
	
	
	
	
}

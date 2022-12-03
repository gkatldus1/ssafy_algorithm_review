package com.ssafy.review1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		long start = 0;
		long last = trees[N-1];
		long mid = 0;
		while(start<=last) {
			mid = (start+last)/2;
			long sum = 0;
			for(int i=0; i<trees.length; i++) {
				if(trees[i] > mid) {
					sum += (trees[i]-mid);
				}
			}
			if(sum >= M) {
				start = mid+1;
			}
			else {
				last = mid-1;
			}
		}
		System.out.println(last);
		
		
		
	}
}

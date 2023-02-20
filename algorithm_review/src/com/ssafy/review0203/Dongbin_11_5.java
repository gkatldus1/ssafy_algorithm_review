package com.ssafy.review0203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_11_5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[11];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int index = Integer.parseInt(st.nextToken());
			arr[index]++;
					
		}
		int result = 0;
		for(int i=1; i<=M; i++) {
			N-=arr[i];
			result += N * arr[i];
			
		}
		System.out.println(result);
		
	}
}

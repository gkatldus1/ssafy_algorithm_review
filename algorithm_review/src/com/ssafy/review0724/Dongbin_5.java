package com.ssafy.review0724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++)	arr[Integer.parseInt(st.nextToken())] +=1 ;
		
		for(int i=0; i<M; i++) {
			N -= arr[i];
			result += N * arr[i];
		}
		
		System.out.println(result);
		
	}
}

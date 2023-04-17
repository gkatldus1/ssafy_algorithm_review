package com.ssafy.review0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_5 {
	static int n, m;
	static int[] arr = new int[11];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] += 1;
		}
		
		int result = 0;
		
		for(int i=1; i<=m; i++) {
			n -= arr[i];
			result += arr[i] * n;
		}
		System.out.println(result);
		
	}
	
	
	
}

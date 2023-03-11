package com.ssafy.review0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_35 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		arr[0] = 1;
		
		int i2=0, i3=0, i5=0;
		int next2=2, next3=3, next5=5;
		
		for(int i=1; i<N; i++) {
			arr[i] = Math.min(next2, Math.min(next3, next5));
			
			if(arr[i] == next2) {
				i2+=1;
				next2 = arr[i2] * 2;
			}
			if(arr[i] == next3) {
				i3+=1;
				next3 = arr[i3] * 3;
			}
			if(arr[i] == next5) {
				i5+=1;
				next5 = arr[i5] * 3;
			}
		}
		
		System.out.println(arr[N-1]);
		
	}
}

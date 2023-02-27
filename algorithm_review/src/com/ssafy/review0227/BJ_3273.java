package com.ssafy.review0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_3273 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int temp = 0;
		int start = 0;
		int end = n-1;
		int count = 0;
		while(start < end) {
			temp = arr[start] + arr[end];
			
			if(temp == x) {
				count++;
				start++;
				end--;
			}
			else if(temp < x) {
				start++;
			}
			else if(temp > x) {
				end--;
			}
			
		}
		
		System.out.println(count);
		
	}
}

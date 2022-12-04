package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		int[] arr = new int[3];
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)	break;
			
			Arrays.sort(arr);
			
			int longest = arr[2]*arr[2];
			int others = arr[0] * arr[0] +  arr[1]*arr[1];
			if(longest == others)	System.out.println("right");
			else	System.out.println("wrong");
			
		}
		
	}
}

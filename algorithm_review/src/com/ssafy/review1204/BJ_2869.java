package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		
		int count = 0;
		
		long height = 0;
		
//		while(height<V) {
//			height += A;
//			count++;
//			if(height >= V ) {
//				break;
//			}
//			height -= B;
//		}
		
		long des = V-A;
		long climb = A-B;
		
		long day = 0;
		
		if(des%climb == 0) day = des/climb; 
		else	day = des/climb + 1;
		
		
		
		System.out.println(day+1);
		
		
	}
}

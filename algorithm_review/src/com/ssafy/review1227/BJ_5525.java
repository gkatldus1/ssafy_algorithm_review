package com.ssafy.review1227;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		int cnt = 0;
		int result = 0;
		
		for(int i=1; i<M-1; i++) {
			if(input[i-1]=='I' && input[i]=='O' && input[i+1]=='I') {
				cnt++;
				if(cnt==N) {
					cnt--;
					result++;
				}
				i++;
			}
			else	cnt=0;
		}
		System.out.println(result);
		
	}
}

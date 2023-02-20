package com.ssafy.review0131;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_11_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			if(Integer.parseInt(arr[i])<=1)	result+=Integer.parseInt(arr[i]);
			else {
				if(result==0)	result+=Integer.parseInt(arr[i]);
				else	result*=Integer.parseInt(arr[i]);
			}
		}
		System.out.println(result);
		
	}
}

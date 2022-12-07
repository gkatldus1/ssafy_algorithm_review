package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10828 {
	static int[] arr;
	static int pointer = 0;
	static void pop() {
		if(pointer == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(arr[pointer-1]);
		pointer--;
		return;
	}
	
	static void push(int num) {
		if(pointer == arr.length-1) {
			//더블링
			int[] temp = new int[arr.length*2];
			for(int i=0; i<arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
			arr[pointer++] = num;
			return;
		}
		arr[pointer++] = num;
	}
	
	static void size() {
		
		System.out.println(pointer);
		return;
	}
	
	static void empty() {
		if(pointer==0) {
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}
	
	static void top() {
		
		if(pointer==0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(arr[pointer-1]);
	}
	
	public static void main(String[] args) throws Exception {
		arr = new int[100];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int l=0; l<N; l++) {
			String[] input = br.readLine().split(" ");
			switch(input[0]) {
				case "push":
					int parameter = Integer.parseInt(input[1]);
					push(parameter);
//					System.out.println(Arrays.toString(arr));
					break;
				case "pop":
					pop();
					break;
				case "size":
					size();
					break;
				case "empty":
					empty();
					break;
				case "top":
					top();
					break;
			}
			
		}
		
		
	}
	
	
	
	
}

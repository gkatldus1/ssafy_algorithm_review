package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_10845_second {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[10001];
		Arrays.fill(arr, 0);
		for(int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for(int i=0; i<10001; i++) {
			for(int j=0; j<arr[i]; j++) {
				bw.write(i+"\n");;
			}
		}
		
		bw.flush();
	}
}

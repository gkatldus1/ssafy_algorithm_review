package com.ssafy.review0404;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class Dongbin_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		int result = 0;
		int state = 0;
		for(int i=0; i<arr.size(); i++) {
			int now = arr.get(i);
			state += 1;
			if(state >= now) {
				state = 0;
				result++;
			}
		}
		System.out.println(result);
		
	}
}

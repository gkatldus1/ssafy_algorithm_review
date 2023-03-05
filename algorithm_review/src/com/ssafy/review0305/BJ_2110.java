package com.ssafy.review0305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int start = 1;
		int end = list.get(N-1) - list.get(0);
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int value = list.get(0);
			int cnt = 1;
			
			for(int i=1; i<N; i++) {
				if(list.get(i) >= value + mid) {
					value = list.get(i);
					cnt += 1;
				}
			}
			
			if(cnt>=C) {
				start = mid + 1;
				result = mid;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(result);
		
		
		
	}
}

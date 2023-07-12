package com.ssafy.review0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arrayList.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arrayList);
		
		int count = 0;
		int result = 0;
		for(int i=0; i<arrayList.size(); i++) {
			int now = arrayList.get(i);
			count++;
			if(now<=count) {
				result++;
				count = 0;
			}
			
		}
		System.out.println(count);
		
	}
}

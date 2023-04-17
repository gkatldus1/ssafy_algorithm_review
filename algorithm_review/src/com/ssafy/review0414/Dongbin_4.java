package com.ssafy.review0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_4 {
	static int n;
	static ArrayList<Integer> arrayList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrayList.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arrayList);
		
		int target = 1;
		for(int i=0; i<n; i++) {
			if(target < arrayList.get(i)) break;
			target += arrayList.get(i);
		}
		System.out.println(target);
	}
	
}

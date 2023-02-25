package com.ssafy.review0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_11_4 {
	
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int target = 1;
		for(int i=0; i<n; i++) {
			if(target<list.get(i))	break;
			target += list.get(i);
					
		}
		System.out.println(target);
		
		
	}
}

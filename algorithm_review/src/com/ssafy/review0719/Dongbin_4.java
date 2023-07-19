package com.ssafy.review0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i=0; i<n; i++)	arrayList.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(arrayList);
		
		int target = 1;
		for(int i=0; i<arrayList.size(); i++) {
			int now = arrayList.get(i);
			if(target < now)	break;
			target += now;
			
		}
		System.out.println(target);
		
	}
}

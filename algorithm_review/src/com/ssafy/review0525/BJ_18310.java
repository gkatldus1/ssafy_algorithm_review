package com.ssafy.review0525;

import java.util.*;

public class BJ_18310 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arrayList.add(sc.nextInt());
		}
		
		Collections.sort(arrayList);
		
		System.out.println(arrayList.get((n-1) / 2));
		
	}
}

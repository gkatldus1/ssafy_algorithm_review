package com.ssafy.review1202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BJ_2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int sum = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		System.out.println(Math.round(sum/(double)N));
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		int max_frequent = 0;
		for(int val: map.values()) {
			if(val>max_frequent) {
				max_frequent = val;
			}
		}
		ArrayList<Integer> list  = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key) == max_frequent) {
				list.add(key);
			}
		}
		Collections.sort(list);

		if(list.size()==1) {
			System.out.println(list.get(0));
		}else {
			System.out.println(list.get(1));
		}
		
		System.out.println(arr[N-1]-arr[0]);
		
	}
}

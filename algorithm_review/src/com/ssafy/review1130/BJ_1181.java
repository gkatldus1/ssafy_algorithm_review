package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class BJ_1181 {
	public static void main(String[] args) throws Exception {
		HashSet<String> hs = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			hs.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<>(hs);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else {
					return o1.length() - o2.length();
				}
			}
			
		} );
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}
}

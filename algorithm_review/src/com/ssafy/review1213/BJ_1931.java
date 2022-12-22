package com.ssafy.review1213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<int[]> ans = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int[] arr = new int[] {s, e};
			list.add(arr);
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[1]==arr2[1]) {
					return arr1[0]  - arr2[0];
				}
				return arr1[1]-arr2[1];
			}
		});
		ans.add(list.get(0));
		int cnt = 0;
		for(int i=1; i<list.size(); i++) {
			int[] cur = list.get(i);
			if(ans.get(cnt)[1]<=cur[0]) {
				ans.add(cur);
				cnt++;
			}
		}
//		for(int[] ele : list) {
//			System.out.print(Arrays.toString(ele)+" ");
//		}
//		System.out.println();
		System.out.println(ans.size());
	}
}

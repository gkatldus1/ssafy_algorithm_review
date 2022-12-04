package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			
			list.add(arr);
			
		}
		
		for(int i=0; i<list.size(); i++) {
			int[] cur = list.get(i);
			int count = 0;
			for(int j=0; j<list.size(); j++) {
				if(j==i)	continue;
				int[] other = list.get(j);
				if(other[0]>cur[0] && other[1]> cur[1])	count++;
				
			}
			sb.append(++count).append(" ");
		}
		System.out.println(sb);
		
	}
}

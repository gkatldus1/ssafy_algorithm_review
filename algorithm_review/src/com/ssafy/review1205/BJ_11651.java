package com.ssafy.review1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import com.ssafy.review1205.BJ_11650.Pointer;

public class BJ_11651 {
	static class Pointer implements Comparable<Pointer>{
		int x;
		int y;
		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pointer p) {
			if(this.y == p.y) {
				return this.x - p.x;
			}
			return this.y - p.y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Pointer[] arr = new Pointer[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = new Pointer(x,y);
			
		}
//		Arrays.sort(arr);
		
		Arrays.sort(arr, new Comparator<Pointer>() {

			@Override
			public int compare(Pointer o1, Pointer o2) {
				if(o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
			
		});
		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].x+" "+arr[i].y);
		}
		
	}
	
}

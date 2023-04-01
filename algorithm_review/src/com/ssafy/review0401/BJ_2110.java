package com.ssafy.review0401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		int start = 1;
		int end = arr.get(n-1) - arr.get(0);
		int result = 0;
		
		while(start <= end) {
			//mid는 인접한 두 공유기 사이의 거리를 뜻함
			int mid = (start + end) / 2;
			//첫쨰 집에는 무조건 공유기를 설치한다고 가정
			int value = arr.get(0);
			//value는 마지막으로 공유기를 설치한 장소
			int cnt = 1;
			
			for(int i=1; i<n; i++) {
				if(arr.get(i) >= value + mid) {
					value = arr.get(i);
					cnt += 1;
				}
			}
			if(cnt >= c) {
				start = mid+1;
				result = mid;
			}
			else {
				end = mid-1;
			}
		}
		
		System.out.println(result);
	}
}

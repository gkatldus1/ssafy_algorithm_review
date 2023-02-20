package com.ssafy.review0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_16198 {
	static int result = Integer.MIN_VALUE;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		
		
		combi(arr, 0);
		System.out.println(result);
		
	}
	
	static void combi(ArrayList<Integer> arr,int val) {
		
		if(arr.size()==2) {
			result = Math.max(result, val);
			return;
		}
		
		for(int i=1; i<arr.size()-1; i++) {
			val += (arr.get(i-1) * arr.get(i+1));
			int remove = arr.get(i);
			arr.remove(i);
			combi(arr,val);
			arr.add(i, remove);
			val -=(arr.get(i-1) * arr.get(i+1));
		}
	}
	
	
	
}

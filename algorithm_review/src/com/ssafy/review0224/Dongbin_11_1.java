package com.ssafy.review0224;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Dongbin_11_1 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int count = 0;
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			count++;
			if(count>=list.get(i)) {
				count = 0;
				result++;
			}
		}
		
		System.out.println(result);
	}
}

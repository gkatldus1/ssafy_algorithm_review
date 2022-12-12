package com.ssafy.review1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] listen = new String[N];
		String[] see = new String[M];
		for(int i=0; i<N; i++) {
			listen[i] = br.readLine();
			
		}
		
		for(int i=0; i<M; i++) {
			see[i] = br.readLine();
		}
		
		Arrays.sort(listen);
		Arrays.sort(see);
		
		
		if(N>=M) {
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(listen[j].equals(see[i])) {
						list.add(see[i]);
						break;
					}
				}
			}
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(see[j].equals(listen[i])) {
						list.add(listen[i]);
						break;
					}
				}
			}
		}
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

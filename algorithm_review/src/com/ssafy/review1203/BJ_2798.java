package com.ssafy.review1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2798 {
	
	static int diff = Integer.MAX_VALUE;
	static int ans;
	static int[] cards;
	static int[] selected;
	static int M;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];
		selected = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 0, N);
		System.out.println(ans);
		
		
		
	}
	
	static void DFS(int round, int start, int N) {
		if(round == 3) {
			
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += selected[i];
//				System.out.println(Arrays.toString(selected));
			}
//			System.out.println(sum);
			
			if(sum <= M) {
				if(diff>(M-sum)) {
					diff = M-sum;
					ans = sum;
				}
			}
			
			return;
		}
		for(int i=start; i<N; i++) {
			selected[round] = cards[i];
			DFS(round+1, i+1, N);
		}
		
		
	}
	
}

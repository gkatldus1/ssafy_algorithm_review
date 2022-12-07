package com.ssafy.review1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int min_h = Integer.MAX_VALUE;
		int max_h = Integer.MIN_VALUE;
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]<min_h) {
					min_h = map[i][j];
				}else if(map[i][j]>max_h) {
					max_h = map[i][j];
				}
			}
		}
		
		if(N==1 && M==1) {
			System.out.println(0+" "+0);
			return;
		}
		

		
		int ans_t = Integer.MAX_VALUE;
		int ans_h = 0;
		
		for(int i=min_h; i<=max_h; i++) {
			int temp_t = 0;
			int temp_h = 0;
			int temp_b = B;
			boolean flag = true;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k]>i) {
						temp_b += map[j][k] -i;
					}
				}
			}
			
			
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k] == i) {
						continue;
					}else if(map[j][k]<i) {
						if(temp_b< i-map[j][k]) {
							flag = false;
							break;
						}
						temp_t += (i-map[j][k]);
						temp_b -= (i-map[j][k]);
					}else if(map[j][k]>i) {
						temp_t += (map[j][k] - i)*2;

					}
					
					
					
				}
				if(!flag)	break;
			}
			if(flag) {
				if(temp_t<ans_t) {
					ans_t = temp_t;
					ans_h = i;
				}else if(temp_t == ans_t) {
					ans_h = i;
				}
			}

		}
		

		
	}
}

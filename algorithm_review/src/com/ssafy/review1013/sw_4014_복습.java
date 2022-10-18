package com.ssafy.review1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4014_복습 {
	static int T;
	static int N, X;
	static int[][] map;
	static int[][] map2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map2 = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 완료
			sb.append(String.format("#%d %d%n", tc, process()));
			
			
		}
		System.out.println(sb);
	}
	static int process() {
		int count = 0;
		for(int i=0; i<N; i++) {
			if(makeRoad(map[i])) count++;
			if(makeRoad(map2[i])) count++;
		}
		return count;
	}
	static boolean makeRoad(int[] road) {
		int beforeHeight = road[0];
		int size = 0;
		int j=0;
		
		while(j<N) {
			if(road[j] == beforeHeight) {//높이가 같다면
				size++;
				j++;
			}else if(beforeHeight+1 == road[j]) {// 높이가 1크다면
				if(size<X)	return false;
				
				size = 1;
				beforeHeight++;
				j++;
				
			}else if(beforeHeight-1 == road[j]) {//높이가 1작다면
				int count = 0;
				for(int k=j; k<N; k++) {
					if(road[k]!=road[j])	return false;
					
					if(++count == X)	break;
				}
				if(count <X)	return false;
				
				beforeHeight--;
				j+= X;
				size = 0;
				
			}else {//높이가 2이상임
				return false;
			}
		}
		
		
		
		
		
		
		
		return true;
	}
	
}

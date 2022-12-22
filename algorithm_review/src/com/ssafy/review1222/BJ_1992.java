package com.ssafy.review1222;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1992 {
	static StringBuilder sb = new StringBuilder();
	static char[][] video;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		video = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				video[i][j] = str.charAt(j);
			}
		}
		
		district(0,0, N);
		System.out.println(sb);
		
	}
	
	
	
	static void district(int r, int c, int size) {
		if(isPossible(r, c, size)) {
			
			return;
		}
		int sep = size/2;
		sb.append('(');
		district(r, c, sep); district(r, c+sep, sep); 
        district(r+sep, c, sep); district(r+sep, c+sep, sep); 
        sb.append(')');
	}
	static boolean isPossible(int r, int c, int size) {
		int value = video[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(video[i][j]!=value)	return false;
			}
		}
		if(value=='1')	sb.append(1);
		else	sb.append(0);

		return true;
	}
}

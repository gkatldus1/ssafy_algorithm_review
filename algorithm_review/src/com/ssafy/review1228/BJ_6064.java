package com.ssafy.review1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6064 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			boolean flag = false;
			for(int i=x; i<M*N; i+=M) {
				
				System.out.println("i :"+i+" x:"+x+" y:"+y);
				if(i%N==y) {
					System.out.println(i+1);
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println(-1);
			}
			
			
		}
		
		
		
	}
}

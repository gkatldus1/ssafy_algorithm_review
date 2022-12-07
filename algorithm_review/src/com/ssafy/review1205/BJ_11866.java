package com.ssafy.review1205;

import java.util.Scanner;

public class BJ_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		int p_cnt = 0;
		int index = 0;
		int count = K;
		sb.append("<");
		while(p_cnt != N ) {
			
			if(arr[index] == -1) {
				index = (index+1)%N;
			}
			else {
				count--;
				if(count == 0) {
					if(p_cnt==N-1) {
						sb.append(arr[index]);
						p_cnt++;
						continue;
					}
					sb.append(arr[index]+", ");
					
					arr[index] = -1;
					count = K;
					p_cnt++;
					index = (index+1)%N;
				}
				else {
					index = (index+1)%N;
				}
			}
			
		}
		sb.append(">");
		System.out.println(sb);
	}
}

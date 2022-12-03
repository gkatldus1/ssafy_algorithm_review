package com.ssafy.review1203;

import java.util.Scanner;

public class BJ_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean flag = false;
		int ans = 0;
		for(int i=0; i<N-1; i++) {
			int num = i;
			int sum = 0;
			while(num>0) {
				sum += num%10;
				num = num/10;
			}
			if((sum+i) == N) {
				ans = i;
				flag = true;
				break;
			}
		}
		if(flag) System.out.println(ans);
		else	System.out.println(0);
		
		
	}
}

package com.ssafy.review0615;

import java.util.*;

public class Dongbin_35 {
	static int n;
	static int[] ugly = new int[1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int i2=0, i3=0, i5=0;
		int next2 = 2, next3=3, next5=5;
		
		for(int l=1; l<n; l++) {
			ugly[l] = Math.min(next2, Math.min(next3, next5));
			if(ugly[l] == next2) {
				i2+=1;
				next2 = ugly[i2]*2;
			}
			if(ugly[l] == next3) {
				i3+=1;
				next3 = ugly[i3]*3;
			}
			if(ugly[l] == next5) {
				i5+=1;
				next5 = ugly[i5]*5;
			}
		}
		System.out.println(ugly[n-1]);
		
	}
	
	
	
}

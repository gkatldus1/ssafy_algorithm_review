package com.ssafy.review0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split("");
//		for(int i=0; i<nums.length; i++) {
//			System.out.println(nums[i]);
//		}
		int left = 0;
		int right = 0;
		int mid = nums.length/2;
		for(int i=0; i<mid; i++) {
			left += Integer.parseInt(nums[i]);
		}
		for(int i=mid; i<nums.length; i++) {
			right += Integer.parseInt(nums[i]);
		}
		if(left == right)	System.out.println("LUCKY");
		else System.out.println("READY");
	}
}

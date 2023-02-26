package com.ssafy.review0226;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_14888 {
	
	static int n;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int add, sub, mul, divi;
	
	static int minValue = Integer.MAX_VALUE;
	static int maxValue = Integer.MIN_VALUE;
	
	static void dfs(int i, int now) {
		if(i==n) {
			minValue = Math.min(minValue, now);
			maxValue = Math.max(maxValue, now);
		}
		else {
			if(add > 0) {
				add -= 1;
				dfs(i+1, now + arr.get(i));
				add += 1;
			}
			if(sub > 0) {
				sub -= 1;
				dfs(i+1, now - arr.get(i));
				sub +=1;
			}
			if(mul > 0) {
				mul -= 1;
				dfs(i+1, now * arr.get(i));
				mul += 1;
			}
			if(divi > 0) {
				divi -= 1;
				dfs(i+1, now / arr.get(i));
				divi += 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		add = Integer.parseInt(st.nextToken());
		sub = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		divi = Integer.parseInt(st.nextToken());
		
		dfs(1, arr.get(0));
		
		System.out.println(maxValue);
		System.out.println(minValue);
	}
}

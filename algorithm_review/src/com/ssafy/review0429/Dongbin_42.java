package com.ssafy.review0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_42 {
	public static int g, p;
	public static int[] parent = new int[100001];
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a<b)	parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		g = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=g; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for(int i=0; i<p; i++) {
			int x = Integer.parseInt(br.readLine());
			int root = findParent(x);
			if(root == 0)	break;
			unionParent(root, root-1);
			result += 1;
		}
		System.out.println(result);
	}
	
	
}

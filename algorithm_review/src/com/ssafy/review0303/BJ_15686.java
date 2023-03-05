package com.ssafy.review0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15686 {
	
	static class Position{
		int r, c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Combination{
		private int n;
		private int r;
		private int[] now;
		private ArrayList<ArrayList<Position>> result;
		
		public ArrayList<ArrayList<Position>> getResult(){
			return this.result;
		}
		
		public Combination(int n, int r) {
			this.n = n;
			this.r = r;
			this.now = new int[r];
			this.result = new ArrayList<>();
		}
		
		public void combination(ArrayList<Position> arr, int depth, int index, int target) {
			if(depth == r) {
				ArrayList<Position> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) {
					temp.add(arr.get(now[i]));
				}
				result.add(temp);
				return;
			}
			if(target == n)	return;
			now[index] = target;
			combination(arr, depth+1, index+1, target+1);
			combination(arr, depth, index, target+1);
		}
	}
	
	static int getSum(ArrayList<Position> candidates) {
		int result = 0;
		for(int i=0; i<house.size(); i++) {
			int hr = house.get(i).r;
			int hc = house.get(i).c;
			int temp = Integer.MAX_VALUE;
			for(int j=0; j<candidates.size(); j++) {
				int cr = candidates.get(j).r;
				int cc = candidates.get(j).c;
//				System.out.println(cr+" "+cc);
				temp = Math.min(temp, Math.abs(hr-cr)+Math.abs(hc-cc));
			}
			result += temp;
		}
		return result;
	}
	
	
	static int n, m;
	static int[][] arr = new int[50][50];
	static ArrayList<Position> chicken = new ArrayList<>();
	static ArrayList<Position> house = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) chicken.add(new Position(i, j));
				if(arr[i][j] == 1)	house.add(new Position(i, j));
				
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		Combination comb = new Combination(chicken.size(), m);
		
		comb.combination(chicken, 0, 0, 0);
		ArrayList<ArrayList<Position>> candidates = comb.getResult();
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<candidates.size(); i++) {
			ans = Math.min(ans, getSum(candidates.get(i)));
		}
		
		System.out.println(ans);
		
		
	}
	
	
	
}

package com.ssafy.review0527;

import java.util.*;

public class Dongbin_26 {
	static class Node implements Comparable<Node>{
		
		private int stage;
		private double fail;
		
		public Node(int stage, double fail) {
			this.stage = stage;
			this.fail = fail;
		}
		
		public int getStage() {
			return this.stage;
		}
		
		@Override
		public int compareTo(Node other) {
			if(this.fail == other.fail)	return Integer.compare(this.stage, other.stage);
			return Double.compare(other.fail, this.fail);
		}
	}
	
	static class Solution{
		public int[] solution(int N, int[] stages) {
			int[] answer = new int[N];
			ArrayList<Node> arrayList = new ArrayList<>();
			int length= stages.length;
			
			for(int i=1; i<=N; i++) {
				int cnt = 0;
				for(int j=0; j<stages.length; j++) {
					if(stages[j] == i) {
						cnt+=1;
					}
				}
				
				double fail = 0;
				if(length >= 1) {
					fail = (double)cnt / length;
				}
				arrayList.add(new Node(i, fail));
				length -= cnt;
			}
			
			Collections.sort(arrayList);
			
			for(int i=0; i<N; i++) {
				answer[i] = arrayList.get(i).getStage();
			}
			return answer;
			
		}
	}
	
}

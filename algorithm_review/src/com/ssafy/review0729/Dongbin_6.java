package com.ssafy.review0729;

import java.util.*;

public class Dongbin_6 {
	
	static class Food implements Comparable<Food>{
		int num;
		int quantity;
		
		public Food(int num, int quantity) {
			this.num = num;
			this.quantity = quantity;
		}
	
		@Override
		public int compareTo(Food o) {
			return Integer.compare(this.quantity, o.quantity);
		}
	}
	
	
	public static void main(String[] args) {
		int[] food_times;
		long k;
		
		food_times = new int[] {8, 6, 4};
		k = 15;
		
		PriorityQueue<Food> pq = new PriorityQueue<>();
		
		for(int i=0; i<food_times.length; i++) {
			pq.offer(new Food(i+1, food_times[i]));
		}
		
		int sumValue = 0;
		int previous = 0;
		
		int length = food_times.length;
		
		while(sumValue + (pq.peek().quantity - previous)*length <=k ) {
			int now = pq.poll().quantity;
			sumValue += (now - previous) * length;
			length -= 1;
			previous = now;
		}
		
		ArrayList<Food> arrayList = new ArrayList<>();
		while(true) {
			if(pq.isEmpty())	break;
			arrayList.add(pq.poll());
		}
		Collections.sort(arrayList, new Comparator<Food>(){

			@Override
			public int compare(Food o1, Food o2) {
				
				return Integer.compare(o1.num, o2.num);
			}
			
		});
		
		System.out.println(arrayList.get((int)(k - sumValue) % length).num);
		
	}
}

package com.ssafy.review0124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			PriorityQueue<Integer> minQueue = new PriorityQueue<>();
			PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
			
			StringBuilder sb = new StringBuilder();
			
			int k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(str.equals("I")) {
					minQueue.offer(num);
					maxQueue.offer(num);
				}
				else if(str.equals("D")) {
					if(minQueue.size()==0) {
						
						continue;
					}
					else if(num == 1) {
						int r_num = maxQueue.poll();
						minQueue.remove(r_num);
					}
					else {
						int r_num = minQueue.poll();
						maxQueue.remove(r_num);
					}
				}
				
			}
			if(minQueue.size()==0) {
				System.out.println("EMPTY");
			}
			else {
				int num = maxQueue.poll();
				minQueue.remove(num);
				sb.append(num).append(" ");
				
				if(minQueue.size()==0) {
					sb.append("EMPTY");
				}
				else {
					sb.append(minQueue.poll());
				}
			}
			System.out.println(sb);
			
		}
		
		
	}
}

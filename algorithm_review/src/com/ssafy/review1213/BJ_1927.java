package com.ssafy.review1213;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1927 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(!pq.isEmpty()) {
					bw.write(pq.poll()+"\n");
				}
				else {
					bw.write(0+"\n");
				}
			}
			else {
				pq.offer(num);
			}
		}
		bw.flush();
	}
}

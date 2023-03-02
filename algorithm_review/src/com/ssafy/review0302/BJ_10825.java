package com.ssafy.review0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_10825 {
	static class Node implements Comparable<Node>{
		String name;
		int math;
		int kor;
		int eng;
		public Node(String name, int math, int kor, int eng) {
			this.name = name;
			this.math = math;
			this.kor = kor;
			this.eng = eng;
		}
		
		public int compareTo(Node o) {
			if(this.eng == o.eng && this.kor == o.kor && this.math == o.math) {
				return name.compareTo(o.name);
				
			}
			else if(this.kor == o.kor && this.eng == o.eng) {
				return Integer.compare(o.math, this.math);
			}
			else if(this.kor == o.kor) {
				return Integer.compare(this.eng, o.eng);
			}
			return Integer.compare(o.kor, this.kor);

			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node> arr = new ArrayList<>();
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			arr.add(new Node(name, math, kor, eng));
		}
		
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).name);
		}
		
	}
	
	
}

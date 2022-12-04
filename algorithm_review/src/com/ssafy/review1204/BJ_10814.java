package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_10814 {
	static class Member{
		String name;
		int age;
		int order;
		public Member(String name, int age, int order) {
			this.name = name;
			this.age = age;
			this.order = order;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Member> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(name, age, i));
		}
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age == o2.age) {
					return o1.order - o2.order;
				}
				return o1.age - o2.age;
			}
		});
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).age+" "+list.get(i).name);
		}
		
	}
	
	
}

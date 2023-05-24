package com.ssafy.review0524;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10825 {
	static class Student implements Comparable<Student>{
		String name;
		int kor, eng, math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		
		
		@Override
		public int compareTo(Student o) {
			if(this.kor == o.kor && this.eng == o.eng && this.math == o.math) return this.name.compareTo(o.name);
			
			if(this.kor == o.kor && this.eng == o.eng)	return Integer.compare(o.math, this.math);
			
			if(this.kor == o.kor)	return Integer.compare(this.eng, o.eng);
			
			return Integer.compare(o.kor, this.kor);
		}
	}		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> arr = new ArrayList<>();
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++)	
			System.out.println(arr.get(i).name);
		
	}
		
}

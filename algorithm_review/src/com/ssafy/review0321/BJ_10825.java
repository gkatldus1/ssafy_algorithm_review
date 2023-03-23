package com.ssafy.review0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_10825 {
	static class Student implements Comparable<Student>{
		int kor, eng, math;
		String name;
		public Student(int kor, int eng, int math, String name) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.name = name;
		}
		
		@Override
		public int compareTo(Student s) {
			if(this.kor == s.kor && this.eng == s.eng && this.math == s.math)
				return name.compareTo(s.name);
			else if(this.kor == s.kor && this.eng == s.eng)
				return Integer.compare(s.math, this.math);
			else if(this.kor == s.kor)
				return Integer.compare(this.eng, s.eng);
			return Integer.compare(s.kor, this.kor);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Student> students = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			students.add(new Student(kor, eng, math, name));
		}
		Collections.sort(students);
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).name);
		}
		
	}
}

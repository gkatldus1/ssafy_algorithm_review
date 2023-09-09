package com.ssafy.review0909;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dongbin_23 {
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
            if (this.kor == o.kor && this.math == o.math && this.eng == o.eng) return this.name.compareTo(o.name);
            else if(this.kor == o.kor && this.eng == o.eng) return Integer.compare(o.math, this.math);
            else if(this.kor == o.kor) return Integer.compare(this.eng, o.eng);

            return Integer.compare(o.kor, this.kor);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student s = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.offer(s);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }


    }



}

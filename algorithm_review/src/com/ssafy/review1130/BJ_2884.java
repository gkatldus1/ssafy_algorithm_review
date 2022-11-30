package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2884 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		if(min < 45) {
			if(hour == 0) {
				hour = 23;
			}else {
				hour--;
			}
			
			min = 60+min - 45;
			bw.write(hour+" "+min);
		}else {
			min = min - 45;
			bw.write(hour+" "+min);
		}
		bw.flush();
	}
}

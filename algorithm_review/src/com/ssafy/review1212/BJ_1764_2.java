package com.ssafy.review1212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1764_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> list = new ArrayList<String>(); 
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), i);
		}
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		bw.write(list.size()+"\n");
		for(int i=0; i<list.size(); i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		
	}
}

package com.ssafy.review1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620 {
	public static boolean isInteger(String strValue) {
		try {
			Integer.parseInt(strValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			map.put(i, str);
			map2.put(str, i);
		}
		for(int i=1; i<=M; i++) {
			String str = br.readLine();
			if(isInteger(str)) {
				int num = Integer.parseInt(str);
				sb.append(map.get(num)).append('\n');
			}else {
				sb.append(map2.get(str)).append('\n');
			}
		}
		System.out.println(sb);
		
	}
	
	
	
	
}

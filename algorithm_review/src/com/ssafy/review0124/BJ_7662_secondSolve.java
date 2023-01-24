package com.ssafy.review0124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662_secondSolve {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			StringBuilder sb = new StringBuilder();
			
			int k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(str.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}
				else {
					if(map.isEmpty())	continue;
					
					if(num == 1) {
						int key = map.lastKey();
						if(map.get(key)==1) map.remove(key);
						else map.put(key, map.get(key)-1);
						
					}
					else {
						int key = map.firstKey();
						if(map.get(key)==1)	map.remove(key);
						else map.put(key, map.get(key)-1);
					}
				}
				
			}
			if(map.isEmpty())	System.out.println("EMPTY");
			else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey());
				System.out.println(sb);
			}
			
		}
		
		
	}
}

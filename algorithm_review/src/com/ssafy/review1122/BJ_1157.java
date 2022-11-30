package com.ssafy.review1122;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		HashMap<Character, Integer>map = new HashMap<Character,Integer>();
		char[] charArr = str.toCharArray();
		for(int i=0; i<charArr.length; i++) {
			if(map.containsKey(charArr[i])) {
				map.put(charArr[i], map.get(charArr[i])+1);
			}
			else {
				map.put(charArr[i], 1);
			}
		}
		int max = 0;
		char max_char = 'a';
		for(int i=0; i<charArr.length; i++) {
			if(map.get(charArr[i])>max) {
				max_char = charArr[i];
				max = map.get(charArr[i]);
			}
		}
		
		for(int i=0; i<charArr.length; i++) {
			
			if(map.get(charArr[i])==max) {
				if(max_char != charArr[i]) {
					max_char = '?';
					
					break;
				}
			}
		}
		System.out.println(max_char);
		
	}
}

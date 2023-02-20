package com.ssafy.review0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Dongbin_12_08 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int value = 0;
		ArrayList<Character> list = new ArrayList<>();
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			if(Character.isAlphabetic(ch)) {
				list.add(ch);
			}
			else {
				value += ch - '0';
			}
			
		}
		Collections.sort(list);
		String ans = "";
		for(char ch : list) {
			ans+=ch;
		}
		if(value!=0)	ans+=value;
		System.out.println(ans);
	}
}

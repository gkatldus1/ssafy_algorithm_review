package com.ssafy.review0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_8 {
	public static String str;
	public static ArrayList<Character> result= new ArrayList<>();
	public static int value = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				result.add(str.charAt(i));
			}
			else {
				value += str.charAt(i) - '0';
			}
		}
		
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
				
		if(value != 0) System.out.print(value);
		System.out.println();
		
	}
}

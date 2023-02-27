package com.ssafy.review0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Dongbin_12_08 {
	static ArrayList<Character> alpa = new ArrayList<>();
	static ArrayList<Integer> num = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z')	alpa.add(str.charAt(i));
			else num.add(str.charAt(i)-'0');
		}
		Collections.sort(alpa);
		
		int sum = 0;
		String ans = "";
		for(int i=0; i<alpa.size(); i++)	
			ans += alpa.get(i);
		for(int i=0; i<num.size(); i++)
			sum += num.get(i);
		ans += sum;
		System.out.println(ans);
	}
	
	
}

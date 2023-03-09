package com.ssafy.review0308;

import java.util.*;

public class Dongbin_18 {
	public int balancedIndex(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(')	count+=1;
			else count -= 1;
			if(count==0)	return i;
		}
		return -1;
	}
	
	public boolean checkProper(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(')	count+=1;
			else {
				if(count == 0) {
					return false;
				}
				count -= 1;
			}
		}
		return (count==0)? true: false;
	}
	
	public String solution(String p) {
		String answer = "";
		if(p.equals(""))	return answer;
		int index = balancedIndex(p);
		String u = p.substring(0, index+1);
		String v = p.substring(index+1);
		
		if(checkProper(u)) {
			answer = u + solution(v);
		}
		else {
			answer = "(";
			answer += solution(v);
			answer += ")";
			
			u = u.substring(1, u.length()-1);
			String temp = "";
			for(int i=0; i< u.length(); i++) {
				if(u.charAt(i) == '(')	temp+=")";
				else temp += "(";
			}
			answer += temp;
			
		}
		return answer;
	}
	
}

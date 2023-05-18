package com.ssafy.review0518;

import java.util.*;

public class Dongbin_18 {
	//균형잡힌 괄호 문자열의 인덱스 반환
	 public int balancedIndex(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(')	count+=1;
			else 	count-=1;
			if(count == 0)	return i;
		}
		return -1;
	}
	
	//올바른 괄호 문자열인지 판단
	public boolean checkProper(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(')	count+=1;
			else {
				if(count == 0)	return false;
				count-=1;
			}
		}
		if(count == 0)	return true;
		else return false;
	}
	
	public String solution(String p) {
		String answer = "";
		if(p.equals(""))	return answer;
		int index = balancedIndex(p);
		String u = p.substring(0, index+1);
		String v = p.substring(index+1);
		
		if(checkProper(u))	answer = u + solution(v);
		
		else {
			answer = "(";
			answer += solution(v);
			answer += ")";
			u = u.substring(1, u.length()-1);//첫번쨰와 마지막 문자를 제거
			String temp = "";
			for(int i=0; i<u.length(); i++) {
				if(u.charAt(i) == '(')	temp+= ")";
				else temp += "(";
			}
			answer += temp;
		}
		return answer;
	}
}

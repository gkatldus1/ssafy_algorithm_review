package com.ssafy.review0604;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_30 {
	public int lowerBound(ArrayList<String> arr, String target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			//사전순으로 같거나 뒤에 있다면
			if(arr.get(mid).compareTo(target) >= 0)	end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	public int upperBound(ArrayList<String> arr, String target, int start, int end) {
		while(start < end) {
			int mid = (start+end) / 2;
			//arr[mid]가 target 보다 사전순으로 뒤에 있다면
			if(arr.get(mid).compareTo(target)>0)	end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	public int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.size());
		int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
		return rightIndex - leftIndex;		
	}
	
	public ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> reversedArr = new ArrayList<ArrayList<String>>();
	
	public int[] solution(String[] words, String[] queries) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0; i<10001; i++) {
			arr.add(new ArrayList<String>());
			reversedArr.add(new ArrayList<String>());
		}
		
		for(int i=0; i<words.length; i++) {
			String word = words[i];
			arr.get(word.length()).add(word);
			word = (new StringBuffer(word)).reverse().toString();
			reversedArr.get(word.length()).add(word);
		}
		for(int i=1; i<10001; i++) {
			Collections.sort(arr.get(i));
			Collections.sort(reversedArr.get(i));
		}
		
		for(int i=0; i<queries.length; i++) {
			String q = queries[i];
			int res = 0;
			if(q.charAt(0) != '?') {
				res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
			}
			else {
				q = (new StringBuffer(q)).reverse().toString();
				res =  countByRange(reversedArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
			}
			ans.add(res);
		}
		
		int[] answer = new int[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}
	
	
	
}

package com.ssafy.review1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class BJ_4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		HashMap<Character,Character> map = new HashMap<>();
		map.put('(',')');
		map.put('[', ']');
		LinkedList<Character> stack;
		while(true) {
			String str = br.readLine();
//			String str = sc.nextLine();
			boolean flag = true;
			if(str.equals("."))	break;
			
			char[] arr = str.toCharArray();
			stack = new LinkedList<>();
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == '(') {
					stack.push(arr[i]);
				}
				else if(arr[i] == ')') {
					if(stack.isEmpty()) {
						System.out.println("no");
						flag = false;
						break;
					}
					
					if(map.get(stack.pop()) == arr[i]) {
						continue;
					}
					System.out.println("no");
					flag = false;
					break;
				}
				
				else if(arr[i] == '[') {
					stack.push(arr[i]);
				}
				else if(arr[i] == ']') {
					if(stack.isEmpty()) {
						System.out.println("no");
						flag = false;
						break;
					}
					
					if(map.get(stack.pop()) == arr[i]) {
						continue;
					}
					System.out.println("no");
					flag = false;
					break;
				}
			}
			if(flag) {
				if(stack.isEmpty()) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			
		}
		
		
		
	}
}

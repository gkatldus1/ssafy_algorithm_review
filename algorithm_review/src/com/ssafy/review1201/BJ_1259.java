package com.ssafy.review1201;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1259 {
	public static void main(String[] args) throws Exception {
		//A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(!(str = br.readLine()).equals("0")) {
			 if(str.equals(new StringBuilder().append(str).reverse().toString()))
				 System.out.println("yes");
			 else
				 System.out.println("no");
		}
		
	}
}

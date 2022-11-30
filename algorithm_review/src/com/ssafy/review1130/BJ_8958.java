package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());
		for(int l=0; l<loop; l++) {
			String str = br.readLine();
			int cur = 0;
			int ans = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == 'O') {
					cur++;
				}else {
					cur = 0;
				}
				ans += cur;
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		
		
	}
}

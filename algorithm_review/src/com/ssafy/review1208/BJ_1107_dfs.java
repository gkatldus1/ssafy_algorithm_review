package com.ssafy.review1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1107_dfs {
	public static String targetChannel;
	public static int N = 0, answer = Integer.MAX_VALUE;
	public static List<Integer> button = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		targetChannel = br.readLine();
		N = Integer.parseInt(br.readLine());
		if (N != 0) {
			st = new StringTokenizer(br.readLine());
		}
		for (int n = 0; n < N; n++) {
			button.add(Integer.parseInt(st.nextToken()));
		}
		dfs(0, new StringBuilder());
		answer = answer > Math.abs(Integer.parseInt(targetChannel) - 100)
				? Math.abs(Integer.parseInt(targetChannel) - 100)
				: answer;
		System.out.println(answer);
	}

	public static void dfs(int count, StringBuilder sb) {
		if (count > targetChannel.length()) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (button.contains(i)) {
				continue;
			}
			sb.append(i);
			int result = sb.length() + Math.abs(Integer.parseInt(targetChannel) - Integer.parseInt(sb.toString()));
			answer = answer > result ? result : answer;
			dfs(count + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
		
		
		
	

}

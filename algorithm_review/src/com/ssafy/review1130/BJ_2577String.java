package com.ssafy.review1130;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2577String {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int[] arr = new int[10];
        int sum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        String str = Integer.toString(sum);
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';
            arr[index]++;
        }

        for(int i=0; i<10;i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
    }
}

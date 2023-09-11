package com.ssafy.review0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dongbin_24 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] homes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) homes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(homes);

        System.out.println(homes[(N-1)/2]);

    }

}

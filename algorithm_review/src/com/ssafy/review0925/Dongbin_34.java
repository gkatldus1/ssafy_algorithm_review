package com.ssafy.review0925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dongbin_34 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        for(int i=0; i<N; i++)  dp[i] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.reverse(arrayList);

        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(arrayList.get(j) < arrayList.get(i)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(dp[i] > maxNum)   maxNum = dp[i];
        }

        System.out.println(N- maxNum);

    }


}

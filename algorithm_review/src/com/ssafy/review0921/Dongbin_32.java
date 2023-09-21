package com.ssafy.review0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dongbin_32 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)  Arrays.fill(dp[i], 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                dp[i][index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }

        int up = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) up = 0;
                else up = dp[i - 1][j - 1];

                if(j == i)  right = 0;
                else right = dp[i-1][j];

                dp[i][j] =dp[i][j] + Math.max(up, right);

            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)  if(dp[n-1][i] > max) max = dp[n-1][i];

        System.out.println(max);

    }
}

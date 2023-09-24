package com.ssafy.review0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dongbin_33 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N];
        int[] price = new int[N];
        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 0);
        int maxValue = 0;
        for (int i = N - 1; i >= 0; i--) {
            int t = time[i] + i;

            if(t <= N) {
                dp[i] = Math.max(dp[t] + price[i], maxValue);
//                System.out.println(dp[t] + price[i]);

                maxValue = dp[i];
            }
            else{
                dp[i] = maxValue;
            }

        }
        System.out.println(maxValue);

    }

}

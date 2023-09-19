package com.ssafy.review0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_31 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < T; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] gold = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    gold[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int left = 0;
            int upLeft = 0;
            int downLeft = 0;

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(j == 0)  upLeft = 0;
                    else upLeft = gold[j - 1][i - 1];

                    if(j == n-1)    downLeft = 0;
                    else downLeft = gold[j + 1][i - 1];

                    left = gold[j][i - 1];

                    gold[j][i] += Math.max(upLeft, Math.max(downLeft, left));
                }
            }

            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (gold[i][j] > maxValue) maxValue = gold[i][j];
                }
            }
            System.out.println(maxValue);


        }

    }


}

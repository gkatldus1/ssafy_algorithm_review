package com.ssafy.review0927;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_35 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ugly = new int[N];

        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < N; i++) {
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            if (ugly[i] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[i] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[i] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }

        }
        System.out.println(ugly[N-1]);

    }


}

package com.ssafy.review231119;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Floor {

    public static int[] d = new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + 2 * d[i-2]) % 796796;
        }

        System.out.println(d[n]);
    }


}

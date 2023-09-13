package com.ssafy.review0914;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_28 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N-1;
        boolean flag = false;
        while (start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] == mid){
                System.out.println(mid);
                return;
            }
            else if(arr[mid] < mid) start= mid + 1;

            else if(arr[mid] > mid) end = mid - 1;

        }
        System.out.println(-1);

    }

}

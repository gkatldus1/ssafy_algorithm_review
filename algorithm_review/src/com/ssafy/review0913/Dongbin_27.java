package com.ssafy.review0913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_27 {


    static int countByValue(int[] array, int x) {
        int n = array.length;

        int a = first(array, x, 0, n - 1);

        if (a == -1) return -1;

        int b = last(array, x, 0, n - 1);

        return b - a + 1;
    }


    static int first(int[] array, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if((mid == 0 || target > array[mid-1]) && array[mid] == target) return mid;

        else if(array[mid] >= target) return first(array, target, start, mid - 1);

        else return first(array, target, mid + 1, end);

    }

    static int last(int[] array, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if((mid == end || target < array[mid+1]) && array[mid] == target) return mid;

        else if(array[mid] > target) return last(array, target, start, mid - 1);

        else return last(array, target, mid + 1, end);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = countByValue(arr, x);

        System.out.println(ans);

    }


}

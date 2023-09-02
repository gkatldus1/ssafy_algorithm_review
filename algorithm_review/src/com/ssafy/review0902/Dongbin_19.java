package com.ssafy.review0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbin_19 {

    static int n;
    static int[] data;
    static int add, sub, mul, div;

    static int MIN_VALUE = Integer.MAX_VALUE;
    static int MAX_VALUE = Integer.MIN_VALUE;

    static void dfs(int index, int now) {   //dfs로 완전탐색하여 모든 연산자의 경우의 수를 구하고 그에 따른 값들을 계산한다.
        if (index == n) {
            MAX_VALUE = Math.max(MAX_VALUE, now);
            MIN_VALUE = Math.min(MIN_VALUE, now);
        }
        else {
            if (add > 0) {  //덧셈이 남아있다면
                add -= 1;   //하나 사용
                dfs(index + 1, now + data[index]);  //사용한 때의 다른 경우의 수들을 탐색, 배열의 다른값 계산을 위해 index + 1
                add += 1;   //다른 경우의 수 찾기 위해 원상복귀
            }

            if (sub > 0) {  //이하 동문
                sub -=  1;
                dfs(index + 1, now - data[index]);
                sub += 1;
            }

            if (mul > 0) {
                mul -= 1;
                dfs(index + 1, now * data[index]);
                mul += 1;
            }

            if (div > 0) {
                div -= 1;
                dfs(index + 1, now / data[index]);
                div += 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        data = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());


        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());


        dfs(1, data[0]);

        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);

    }


}

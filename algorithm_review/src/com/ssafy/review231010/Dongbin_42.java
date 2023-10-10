package com.ssafy.review231010;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_42 {
    static int findParent(int[] parent, int x) {
        if (parent[x] != x) parent[x] = findParent(parent, parent[x]);
        return parent[x];

    }


    static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if(a < b)   parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] parent = new int[g + 1];

        for(int i=1; i<=g; i++) parent[i] = i;

        int result = 0;

        for (int i = 0; i < p; i++) {
            int data = findParent(parent, Integer.parseInt(br.readLine()));
            if(data == 0)   break;
            unionParent(parent, data, data-1);
            result += 1;
        }

        System.out.println(result);

    }

}

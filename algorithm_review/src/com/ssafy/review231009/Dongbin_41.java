package com.ssafy.review231009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dongbin_41 {
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if(st.nextToken().equals("1")) unionParent(parent, i+1, j+1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        boolean result = true;

        for (int i = 0; i < arrayList.size()-1; i++) {
            if(findParent(parent, arrayList.get(i)) != findParent(parent, arrayList.get(i+1))){
                result = false;
                break;
            }
        }

        if(result) System.out.println("YES");
        else System.out.println("NO");

    }

}

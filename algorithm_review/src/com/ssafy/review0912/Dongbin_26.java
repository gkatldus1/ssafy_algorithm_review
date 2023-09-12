package com.ssafy.review0912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Dongbin_26 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (pq.size()>=2) {
            int first = pq.poll();

            int second = pq.poll();
            ans += second + first;
            pq.offer(second + first);


        }
        System.out.println(ans);
    }

}

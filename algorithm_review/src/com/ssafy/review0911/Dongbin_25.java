package com.ssafy.review0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dongbin_25 {

    static class Stage implements Comparable<Stage>{
        int num;
        double probability;

        public Stage(int num, double probability) {
            this.num = num;
            this.probability = probability;
        }

        @Override
        public int compareTo(Stage o) {
            if(o.probability == this.probability) return Integer.compare(this.num, o.num);

            return Double.compare(o.probability, this.probability);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stage[] stageCount = new Stage[N];

        while (st.hasMoreTokens()) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        int length = arrayList.size();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(j) == i)   count += 1;
            }

            double fail = 0;
            if(length >= 1) fail = (double)count / length;

            stageCount[i-1] = new Stage(i, fail);
            length -= count;
        }

        Arrays.sort(stageCount);
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = stageCount[i].num;
        }

        System.out.println(Arrays.toString(ans));

    }
}

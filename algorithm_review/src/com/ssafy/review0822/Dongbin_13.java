package com.ssafy.review0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Dongbin_13 {

    static class Combination {
        private int n;
        private int r;
        private int[] now; // 현재 조합
        private ArrayList<ArrayList<Position>> result; // 모든 조합

        public ArrayList<ArrayList<Position>> getResult() {
            return result;
        }

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<Position>>();
        }

        public void combination(ArrayList<Position> arr, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<Position> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(arr.get(now[i]));
                }
                result.add(temp);
                return;
            }
            if (target == n) return;
            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        }
    }

    static class Position{
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void setR(int r) {
            this.r = r;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }


    static int getSum(ArrayList<Position> candidates, ArrayList<Position> house) {
        int result = 0;

        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getR();
            int hy = house.get(i).getC();

            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getR();
                int cy = candidates.get(j).getC();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Position> home = new ArrayList<>();
        ArrayList<Position> chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1) home.add(new Position(i, j));
                if(cur == 2) chicken.add(new Position(i, j));
            }
        }

        Combination comb = new Combination(chicken.size(), M);
        comb.combination(chicken, 0, 0, 0);

        ArrayList<ArrayList<Position>> chickens = comb.getResult();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < chickens.size(); i++) {
            int cur = getSum(chickens.get(i), home);
            min = Math.min(min, cur);
        }
        System.out.println(min);


    }


}

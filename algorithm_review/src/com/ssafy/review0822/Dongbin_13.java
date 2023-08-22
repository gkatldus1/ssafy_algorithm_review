package com.ssafy.review0822;

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


}

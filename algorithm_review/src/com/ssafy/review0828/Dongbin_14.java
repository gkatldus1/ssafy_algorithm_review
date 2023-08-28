package com.ssafy.review0828;

import java.util.*;
public class Dongbin_14 {
    static class Permutation {
        private int n;
        private int r;
        private int[] now; // 현재 순열
        private ArrayList<ArrayList<Integer>> result; // 모든 순열

        public ArrayList<ArrayList<Integer>> getResult() {
            return result;
        }

        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<Integer>>();
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void permutation(int[] arr, int depth) {
            // 현재 순열의 길이가 r일 때 결과 저장
            if (depth == r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(now[i]);
                }
                result.add(temp);
                return;
            }
            for (int i = depth; i < n; i++) {
                swap(arr, i, depth);
                now[depth] = arr[depth];
                permutation(arr, depth + 1);
                swap(arr, i, depth);
            }
        }
    }

    public static void main(String[] args) {
        int n = 12; //테스트를 위해 데이터를 넣어줬음
        int[] weak = new int[]{1, 5, 6, 10};
        int[] dist = new int[]{1,2,3,4};

        int length = weak.length;   //취약지점 길이
        ArrayList<Integer> arrayList = new ArrayList<>();   //취약지점을 어디에서 시작하든 한바퀴 돌 수 있도록 원형으로 만들어주기 위한 리스트

        for(int i=0; i<length; i++){
            arrayList.add(weak[i]);
        }
        for (int i = 0; i < length; i++) {  //원형으로 만들어주기 위해 전체 둘레의 길이만큼 더해줌
            arrayList.add(weak[i] + n);
        }

        int answer = dist.length + 1;   //순회가 불가능한 경우 찾기 위해 처음 답은 친구 수 +1로 초기화
        Permutation pm = new Permutation(dist.length, dist.length); //순열로 친구들 줄세운 모든 경우의 수 구하기
        pm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> perms = pm.getResult();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < perms.size(); j++) {
                int cnt = 1;
                int position = weak[i] + perms.get(j).get(cnt - 1); //첫번째 친구 시작
                for (int k = i; k < i + weak.length; k++) {   //시작 지점부터 취약지점 한바퀴 될때까지
                    if (position < arrayList.get(k)) {
                        cnt++;  //새로운 친구 투입
                        if(cnt > dist.length)   break;   //친구 수보다 커지면 탈출
                        position = arrayList.get(k) + perms.get(j).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt);

            }
        }

        if(answer > dist.length) System.out.println(-1);    //실패한 경우
        else System.out.println(answer);


    }


}

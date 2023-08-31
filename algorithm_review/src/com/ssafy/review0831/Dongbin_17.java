package com.ssafy.review0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.*;
public class Dongbin_17 {

    static class Virus implements Comparable<Virus>{  //바이러스 클래스 선언, 시간, 바이러스 종류, 위치를 저장한다.
         int time, num, r, c;

        public Virus(int time, int num, int r, int c) {
            this.time = time;
            this.num = num;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Virus o) {     //바이러스 종류를 기준으로 정렬한다.
            return Integer.compare(this.num, o.num);
        }
    }

    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};    //방향 배열
    static int N, K, S, X, Y;
    static ArrayList<Virus> arrayList = new ArrayList<>();      //처음 바이러스들의 종류에 따라 정렬하기 위해 만든 리스트
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    arrayList.add(new Virus(0, map[i][j], i, j));      //바이러스라면 리스트에 넣기
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Collections.sort(arrayList);               //종류에 따라 정렬

        Queue<Virus> queue = new LinkedList<>();
        for (int i = 0; i < arrayList.size(); i++) queue.offer(arrayList.get(i));        //바이러스 순서대로 큐에 넣어준다.

        while (!queue.isEmpty()) {      //bfs 시작
            Virus now = queue.poll();

            int time = now.time;
            int r = now.r;
            int c = now.c;
            int num = now.num;

            if(time == S)   break;        //시간대라면 이미 원하는 X,Y에는 찾아야하는 값이 들어있음.

            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (0 <= nr && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = num;
                        queue.offer(new Virus(time + 1, num, nr, nc));
                    }
                }
            }

        }


        System.out.println(map[X-1][Y-1]);

    }


}

package com.ssafy.review0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class Dongbin_21 {

    static class Position{
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N,L,R;
    static int[][] graph;
    static int[][] union;
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};


    static void process(int r, int c, int index) {
        ArrayList<Position> arrayList = new ArrayList<>();
        arrayList.add(new Position(r, c));

        Deque<Position> queue = new ArrayDeque<>();

        queue.offer(new Position(r, c));
        union[r][c] = index;
        int summary = graph[r][c];
        int count = 1;

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            int x = now.r;
            int y = now.c;

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][1];
                int ny = y + dir[i][0];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && union[nx][ny] == -1) {
                    if (Math.abs(graph[nx][ny] - graph[x][y]) >= L && Math.abs(graph[nx][ny] - graph[x][y]) <= R) {
                        queue.offer(new Position(nx, ny));
                        union[nx][ny] = index;
                        summary += graph[nx][ny];
                        count += 1;
                        arrayList.add(new Position(nx, ny));

                    }
                }

//                System.out.println("/////////////////////");
            }

        }

        for (int i = 0; i < arrayList.size(); i++) {
            Position cur = arrayList.get(i);
            int nr = cur.r;
            int nc = cur.c;
            graph[nr][nc] = summary / count;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        union = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = 0;

        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    union [i][j] = -1;
                }
            }

            int index = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (union[i][j] == -1) {
                        process(i, j, index);
                        index += 1;
                    }
                }
            }

            if(index == N*N)    break;
            totalCount += 1;

        }
        System.out.println(totalCount);


    }

}

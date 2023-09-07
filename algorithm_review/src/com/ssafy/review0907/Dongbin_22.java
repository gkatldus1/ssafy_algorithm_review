package com.ssafy.review0907;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Dongbin_22 {

    static class Position{
        int x1, y1;
        int x2, y2;
        int distance;

        public Position(int x1, int y1, int x2, int y2, int distance) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.distance = distance;

        }
    }


    static ArrayList<Position> getNextPos(Position pos, int[][] board) {
        ArrayList<Position> nextPos = new ArrayList<>();
        int x1 = pos.x1; int y1 = pos.y1; int x2 = pos.x2;; int y2 = pos.y2; int dis = pos.distance;

        for (int i = 0; i < 4; i++) {//위아래 옆으로 움직일때
            int nx1 = x1 + dir[i][0];
            int nx2 = x2 + dir[i][0];
            int ny1 = y1 + dir[i][1];
            int ny2 = y2 + dir[i][1];
            int ndis =  dis + 1;
            if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0)
                nextPos.add(new Position(nx1, ny1, nx2, ny2, ndis));
        }

        int[] move = {1, -1};
        //로봇이 가로로 누워있는 경우
        if (x1 == x2) {
            for (int i = 0; i < 2; i++) {
                if (board[x1 + move[i]][y1] == 0 && board[x2 + move[i]][y2] == 0) {
                    nextPos.add(new Position(x1, y1, x1+move[i],y1,dis+1));
                    nextPos.add(new Position(x2, y2, x2 + move[i], y2, dis + 1));
                }
            }
        }

        //로봇이 세로로 놓여있는 경우
        if (y1 == y2) {
            for (int i = 0; i < 2; i++) {
                if (board[x1][y1 + move[i]] == 0 && board[x2][y2 + move[i]] == 0) {
                    nextPos.add(new Position(x1, y1, x1, y1 + move[i], dis+1));
                    nextPos.add(new Position(x2, y2, x2, y2 + move[i], dis+1));
                }
            }
        }

        return nextPos;
    }

    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] board;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N+2][N+2];
        for(int i=0; i<N+2; i++) Arrays.fill(board[i], 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i + 1][j + 1] = Integer.parseInt(st.nextToken());

            }

        }

//        for (int i = 0; i < N + 2; i++) {
//            for (int j = 0; j < N + 2; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }



        Deque<Position> queue = new ArrayDeque<>();
        ArrayList<Position> visited = new ArrayList<>();

        Position start = new Position(1, 1, 1, 2, 0);
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
//            System.out.println(";;;;");
            Position now = queue.poll();
            if((now.x1 == N && now.y1 == N) || (now.x2 == N && now.y2 == N)){
                System.out.println(now.distance);
//                System.out.println("////////////");
                return;
            }

//5
//0 0 0 1 1
//0 0 0 1 0
//0 1 0 1 1
//1 1 0 0 1
//0 0 0 0 0

            ArrayList<Position> nextPos = getNextPos(now, board);
            for (int i = 0; i < nextPos.size(); i++) {
                Position cur = nextPos.get(i);
                Boolean check = true;

                for (int j = 0; j < visited.size(); j++) {
                    if (cur.x1 == visited.get(j).x1 && cur.x2 == visited.get(j).x2 && cur.y1 == visited.get(j).y1 && cur.y2 == visited.get(j).y2) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    queue.offer(cur);
                    visited.add(cur);
                }
            }




        }



    }



}

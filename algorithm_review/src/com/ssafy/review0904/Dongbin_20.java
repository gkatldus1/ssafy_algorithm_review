package com.ssafy.review0904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dongbin_20 {

    static class Position { //선생님 위치 기억할 자료형 선언
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean watch(int r, int c, int dir) {   //4방향으로 학생이 있는지 확인
        if (dir == 0) {
            while (c >= 0) {
                if(temp[r][c].equals("S"))  return true;
                else if(temp[r][c].equals("O") )   return false;
                c -= 1;
            }
        }

        if (dir == 1) {
            while (c < N) {
                if(temp[r][c].equals("S"))  return true;
                else if(temp[r][c].equals("O") )   return false;
                c += 1;
            }

        }

        if (dir == 2) {
            while (r < N) {
                if(temp[r][c].equals("S"))  return true;
                else if(temp[r][c].equals("O") )   return false;
                r += 1;
            }
        }

        if (dir == 3) {
            while (r >= 0) {
                if(temp[r][c].equals("S"))  return true;
                else if(temp[r][c].equals("O") )   return false;
                r -= 1;
            }
        }


        return  false;
    }

    static boolean process() {  //선생님 위치에서 4방향으로 확인하는 함수 실행하는 함수

        for (int j = 0; j < teachers.size(); j++) {
            Position now = teachers.get(j);
            for (int i = 0; i < 4; i++) {
                if(watch(now.x, now.y, i))  return true;
            }

        }
        return false;
    }

    static void dfs(int count){ //깊이 우선 탐색으로 장애물 3개를 만드는 모든 경우의 수 구하기
        if (count == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = board[i][j];
                }
            }

            if(!process()) {    //발견하지 못했으면 "YES" 출력 후 프로그램 종료
//                for (int i = 0; i < N; i++) { 디버깅 하려고 찍어본거
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(temp[i][j] + " ");
//                    }
//                    System.out.println();
//                }
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < N; i++) {   //모든 경우의 수 재귀로 찾기
            for (int j = 0; j < N; j++) {
                if(board[i][j].equals("X")){
                    board[i][j] = "O";
                    count++;
                    dfs(count);
                    board[i][j] = "X";
                    count--;
                }
            }
        }


    }





    static String[][] temp;
    static int N;
    static ArrayList<Position> teachers = new ArrayList<>();
    static String[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new String[N][N];
        temp = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();
                if(board[i][j].equals("T")) teachers.add(new Position(i, j));

            }
        }

        dfs(0);

        System.out.println("NO");



    }



}

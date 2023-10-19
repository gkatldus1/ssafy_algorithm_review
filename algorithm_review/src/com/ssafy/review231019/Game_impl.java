package com.ssafy.review231019;

import java.util.Scanner;

public class Game_impl {
    public static int n, m, x, y, direction;

    public static int[][] d = new int[50][50];

    public static int[][] arr = new int[50][50];

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void turnLeft(){
        direction -= 1;
        if(direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turnTime = 0;

        while (true) {
            turnLeft();

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turnTime = 0;
                continue;
            }
            else    turnTime+=1;

            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if(arr[nx][ny] == 1)    break;
                x = nx;
                y = ny;
                turnTime = 0;
            }

        }
        System.out.println(cnt);


    }

}

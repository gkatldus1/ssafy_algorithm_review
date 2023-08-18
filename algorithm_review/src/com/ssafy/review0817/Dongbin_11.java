package com.ssafy.review0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Dongbin_11 {

    static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Apple{
        int second;
        String direction;

        public Apple(int second, String direction) {
            this.second = second;
            this.direction = direction;
        }
    }

    static Deque<Position> snake = new ArrayDeque<>();
    static ArrayList<Apple> apples = new ArrayList<>();
    static int[][] map;
    static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int turn(int now, String direction) {
        if (direction.equals("L")){
            if(now == 0)    now = 3;
            else now -=1;
        }
        else    now = (now + 1) % 4;

        return now;
    }

    static int simulate(){
        int x = 1, y = 1;

        map[x][y] = 2;

        int now = 0;
        int time = 0;
        int index = 0;
        snake.offer(new Position(x, y));

        while (true) {
            int nx = x + dirs[now][0];
            int ny = y + dirs[now][1];
            // 맵 범위 안에 있고 뱀이 없다면
            if(1<=nx && nx<=n && 1<=ny && ny <=n && map[nx][ny] !=2){
                //사과가 없다면 이동 후 꼬리 제거
                if(map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    snake.offer(new Position(nx, ny));
                    Position prev = snake.pollFirst();
                    map[prev.x][prev.y] = 0;

                }
                //사과가 있다면
                else{
                    map[nx][ny] = 2;
                    snake.offer(new Position(nx, ny));
                }
            }
            else{
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            if(index < l && time == apples.get(index).second){
                now = turn(now, apples.get(index).direction);
                index += 1;

            }
        }
        return time;
    }
    static int n;
    static int k;
    static int l;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         k = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        //사과 정보 입력
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());

        //방향 회전 정보 입력
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            apples.add(new Apple(second, dir));
        }

        int ans = 0;
        ans = simulate();
        System.out.println(ans);

    }



}


package com.ssafy.review0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* 다음엔 완탐이 아닌 콤비네이션으로 풀어도 괜찮을지두 ㅎㅎ
* 
* 
* */


public class Dongbin_16 {



    static int[][] data;
    static int N, M;
    static int[][] temp;
    static int answer = Integer.MIN_VALUE;
    static int[][] dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    static void virus(int x, int y) {   //dfs로 바이러스 증식
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    static int getCount() {//전체 안전 영역 카운트
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void dfs(int wall) { //dfs로 완전탐색하여 벽을 3개 세우는 경우의 수를 찾는다
        if (wall == 3) {    //어라라~ 벽 3개가 만들어졌다?
            for (int i = 0; i < N; i++) {   //바이러스 증식해줄 임시 배열 초기화해줘
                for (int j = 0; j < M; j++) {
                    temp[i][j] = data[i][j];
                }
            }

            for (int i = 0; i < N; i++) {   //dfs로 바이러스 증식해줭
                for (int j = 0; j < M; j++) {
                    if(temp[i][j] == 2) virus(i, j);
                }
            }

            answer = Math.max(answer, getCount());  //안전영역 개수가 최대인지 확인해줘~~~

            return;
        }

        for (int i = 0; i < N; i++) {   //보니까 조합이라기보다는 완전탐색에 더 가깝네
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) {  //안전 영역이면
                    data[i][j] = 1; //벽 세워
                    wall++; //벽 갯수 카운트
                    dfs(wall);  //다음 단계로 보내
                    data[i][j] = 0; //다른 경우의 수 탐색을 위해 원상복귀
                    wall--;
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        temp = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0); 

        System.out.println(answer);


    }

}

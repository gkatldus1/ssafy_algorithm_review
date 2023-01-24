package com.ssafy.review0103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {
	 static int[][][] farm;
	    static Queue<int[]> queue = new ArrayDeque<>();

	   static int M, N, H;
	   static int[][] deltas = {{0,0,1},{0,0,-1},{-1,0,0},{1,0,0},{0,1,0},{0,-1,0}};
	    static int t_cnt;
	    static int t_num;
	    static boolean[][][] visited;
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        H = Integer.parseInt(st.nextToken());
	        farm = new int[H][N][M];
	        visited = new boolean[H][N][M];
	        for(int i=0; i<H; i++){
	            for(int j=0; j<N; j++){
	                st = new StringTokenizer(br.readLine());
	                for(int k=0; k<M; k++){
	                    farm[i][j][k] = Integer.parseInt(st.nextToken());
	                    if(farm[i][j][k] == 1){
	                        queue.offer(new int[] {i, j, k});
	                        visited[i][j][k] = true;
	                    }
	                    else if(farm[i][j][k] == 0) t_num++;
	                }
	            }
	        }
	        if(t_num == 0){
	            System.out.println(0);
	            return;
	        }
	        BFS();
//	        for(int i=0; i<H; i++){
//	            for(int j=0; j<N; j++){
//	                st = new StringTokenizer(br.readLine());
//	                for(int k=0; k<M; k++){
//	                    System.out.print(farm[i][j][k]+" ");
//	                }
//	            }
//	            System.out.println();
//	        }
	    }
	    static void BFS(){
	        int day = 0;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            day++;
	            while(size-->0){
	                int[] cur = queue.poll();
	                int h  = cur[0];
	                int n = cur[1];
	                int m = cur[2];
	                for(int i=0; i< deltas.length; i++){
	                    int nh = h+deltas[i][0];
	                    int nn = n+deltas[i][1];
	                    int nm = m+deltas[i][2];
	                    if(nh<0 || nh>=H || nn<0 || nn>=N || nm<0 || nm>=M) continue;
	                    if(visited[nh][nn][nm]) continue;
	                    if(farm[nh][nn][nm] == -1) continue;

	                    visited[nh][nn][nm] = true;
	                    farm[nh][nn][nm] = 1;
	                    queue.offer(new int[]{nh, nn, nm});
	                    t_cnt++;
	                }

	            }
	            if(t_num == t_cnt){
	                System.out.println(day);
	                return;
	            }
	        }
	        System.out.println(-1);
	    }
}

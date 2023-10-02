package com.ssafy.review231002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dongbin_39 {
    static class Node implements Comparable<Node>{
        int x, y;
        int price;

        public Node(int x, int y, int price) {
            this.x = x;
            this.y = y;
            this.price = price;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.price, other.price);
        }

    }

    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int test = 0; test < tc; test++) {
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int INF = (int)1e9;

            int[][] distance = new int[N][N];
            for(int i=0; i<N; i++)  Arrays.fill(distance[i], INF);

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(0, 0, graph[0][0]));
            distance[0][0] = graph[0][0];

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int dist = now.price;
                int x = now.x;
                int y = now.y;

                if(distance[x][y] < dist)   continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;

                    int cost = dist + graph[nx][ny];

                    if (cost < distance[nx][ny]) {
                        distance[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }

            System.out.println(distance[N-1][N-1]);
        }

    }



}

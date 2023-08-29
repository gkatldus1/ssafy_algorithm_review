package com.ssafy.review0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dongbin_15 {
    static int[] distance;
    static int N, M, K, X;
    static ArrayList<Integer>[] cities;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;
    static boolean flag = false;

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];   //방문했는지 확인 배열
        cities = new ArrayList[N + 1];  //그래프를 담을 배열
        distance = new int[N + 1];      //최소거리 측정
        for (int i = 0; i < N + 1; i++) {
            cities[i] = new ArrayList<Integer>();
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cities[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));

        }

        bfs();
        if(flag){   //정렬 및 출력
            Collections.sort(answer);

            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
        else System.out.println(-1);    //K거리만큼의 노드가 없을때
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X); //bfs 시작하는 곳
        visited[X] = true;  //안쓰게 됨 ㅎ
        distance[X] = 0;
        while (!queue.isEmpty()) {      //bfs로 순회하며 각 노드까지의 최단거리 기록
            int now = queue.poll();
            for (int i = 0; i < cities[now].size(); i++) {
                int nextNode = cities[now].get(i);
                if (distance[nextNode] == -1) {
                    distance[nextNode] = distance[now] + 1;
                    queue.offer(nextNode);
                }
            }

        }
        for (int i = 1; i <= N; i++) {  //K인 거리들만 리스트에 추가
            if (distance[i] == K) {
                answer.add(i);
                flag = true;
            }

        }


    }

}

package com.ssafy.review0818;

import java.util.ArrayList;
import java.util.Collections;

public class Dongbin_12 {

    static class Node implements Comparable<Node>{
        int x,y,z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }


        @Override
        public int compareTo(Node o) {
            if (this.x == o.x && this.y == o.y) return Integer.compare(this.z, o.z);
            if(this.x == o.x) return Integer.compare(this.y, o.y);

            return Integer.compare(this.x, o.x);
        }
    }

    static boolean possible(ArrayList<ArrayList<Integer>> arrayList) {
        //전부 돌면서 가능한 구조물인지 확인
        for (int i = 0; i < arrayList.size(); i++) {
            int x = arrayList.get(i).get(0);
            int y = arrayList.get(i).get(1);
            int z = arrayList.get(i).get(2);

            if(z == 0){ //기둥일때
                boolean check = false;
                if(y == 0)  continue;

                for (int j = 0; j < arrayList.size(); j++) {
                    int r = arrayList.get(j).get(0);
                    int c = arrayList.get(j).get(1);
                    int stuff = arrayList.get(j).get(2);

                    if(x-1 == r && y == c && stuff == 1){
                        check = true;
                        break;
                    }
                    else if(x == r && y == c && stuff == 1){
                        check = true;
                        break;
                    }
                    else if(x == r && y-1 == c && stuff == 0){
                        check = true;
                        break;
                    }

                }

                if(!check)  return check;

            }
            else if(z == 1){ //보일때
                boolean check = false;
                boolean left = false;
                boolean right = false;

                for(int j=0; j<arrayList.size(); j++){
                    int r = arrayList.get(j).get(0);
                    int c = arrayList.get(j).get(1);
                    int stuff = arrayList.get(j).get(2);

                    //기둥 위일때
                    if(x == r && y-1 == c && stuff == 0){
                        check = true;
                        break;
                    }
                    if(x+1 == r && y-1 == c && stuff == 0){
                        check = true;
                        break;
                    }

                    //양쪽 끝부분이 다른 보와 연결
                    if(x-1 == r && y == c && stuff == 1){
                        left = true;
                    }
                    if(x+1 == r && y == c && stuff == 1){
                        right = true;
                    }

                }
                if(left&&right) check = true;
                if(!check)  return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] buildFrame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < buildFrame.length; i++) {
            int x = buildFrame[i][0];
            int y = buildFrame[i][1];
            int stuff = buildFrame[i][2];
            int operate = buildFrame[i][3];

            if (operate == 0) { //삭제하는 경우
                int index = 0;
                for (int j = 0; j < arrayList.size(); j++) {
                    int k = arrayList.get(j).get(0);
                    int l = arrayList.get(j).get(1);
                    int m = arrayList.get(j).get(2);
                    if(k == x && y == l && m == stuff){
                        index = j;
                        break;
                    }
                }
                System.out.println(index);
                ArrayList<Integer> erased = arrayList.get(index);
                arrayList.remove(index);
                if(!possible(arrayList)) arrayList.add(erased);

            }

            else if(operate == 1){  //설치하는경우
                ArrayList<Integer> inserted = new ArrayList<>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(stuff);

                arrayList.add(inserted);
                if(!possible(arrayList)) arrayList.remove(arrayList.size() - 1);
            }


        }

        ArrayList<Node> answer = new ArrayList<Node>();
        for (int i = 0; i < arrayList.size(); i++) {
            answer.add(new Node(arrayList.get(i).get(0), arrayList.get(i).get(1), arrayList.get(i).get(2)));
        }
        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            Node now = answer.get(i);
            System.out.print(now.x +" "+now.y+" "+now.z);
            System.out.println();
        }
    }




}

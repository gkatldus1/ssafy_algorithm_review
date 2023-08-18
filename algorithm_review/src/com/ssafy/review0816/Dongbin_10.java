package com.ssafy.review0816;

import java.util.Arrays;

public class Dongbin_10 {

    static int[][] rotateMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] result = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n - i - 1] = arr[i][j];
            }
        }
        return result;
    }

    static boolean check(int[][] newLock){
        int lockLength = newLock.length/3;
        for(int i=lockLength; i<lockLength*2; i++){
            for(int j=lockLength; j<lockLength*2; j++){
                if(newLock[i][j]!=1)    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int n = lock.length;
        int m = key.length;

        int[][] newLock = new int[n*3][n*3];

        //자물쇠 가운데 부분에 값 넣기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for(int k=0; k<4; k++){
            key = rotateMatrix(key);    // 열쇠회전

            for(int x=0; x<n*2; x++){
                for(int y=0; y<n*2; y++){
                    //자물쇠에 열쇠 끼워넣기
                    for(int i=0; i<m; i++){
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y+j] += key[i][j];
                        }
                    }

                    if(check(newLock) == true){
                        System.out.println("TRUE");
                        return;
                    }

                    for(int i=0; i<m; i++){
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y+j] -= key[i][j];
                        }
                    }

                }
            }


        }

        System.out.println("FALSE");
        return;
    }



}

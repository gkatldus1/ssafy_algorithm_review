package com.ssafy.review0428;

import java.util.*;

public class Dongbin_10 {
	public static int[][] rotateMatrixBy90Degree(int[][] a){
		int n = a.length;	//행
		int m = a[0].length;	//열
		int[][] result = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				result[j][n-i-1] = a[i][j];
			}
		}
		return result;
	}
	
	public static boolean check(int[][] newLock) {
		int lockLength = newLock.length / 3;
		for(int i=lockLength; i< lockLength * 2; i++) {
			for(int j=lockLength; j<lockLength*2; i++) {
				if(newLock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		int n = lock.length;
		int m = key.length;
		
		int[][] newLock = new int[n*3][n*3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				newLock[i+n][j+n] = lock[i][j];
			}
		}
		
		for(int rotation = 0; rotation <4; rotation++) {
			key =  rotateMatrixBy90Degree(key);
			for(int x=0; x<n*2; x++) {
				for(int y=0; y<n*2; y++) {
					//자물쇠에 열쇠 끼워넣기
					for(int i=0; i<m; i++) {
						for(int j=0; j<m; j++) {
							newLock[x+i][y+j] += key[i][j];
						}
					}
					//자물쇠에 열쇠가 들어 맞는지 검사
					if(check(newLock)) return true;
					//자물쇠에서 열쇠 다시 뺴기
					for(int i=0; i<m; i++) {
						for(int j=0; j<m; j++) {
							newLock[x+i][y+j] -= key[i][j];
						}
					}
					
				}
			}
			
			
		}
		return false;
		
	}
	
}

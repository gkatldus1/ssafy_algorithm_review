package com.ssafy.review0301;
import java.util.*;

public class Dongbin_10 {
	static int[][] rotateMatrix(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] result = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				result[j][n-i-1] = a[i][j];
			}
		}
		
		return result;
	}
	
	static boolean check(int[][] newLock) {
		int lockLength = newLock.length/3;
		for(int i=lockLength; i<lockLength*2; i++) {
			for(int j=lockLength; j<lockLength*2; j++) {
				if(newLock[i][j]!=1)	return false;
			}
		}
		return true;
	}
	
	boolean solution(int[][] key, int[][] lock) {
		int n = lock.length;
		int m = key.length;
		
		int[][] newLock = new int[n*3][n*3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				newLock[i+n][j+n] = lock[i][j];
			}
		}
		
		for(int r=0; r<4; r++) {
			key = rotateMatrix(key);
			for(int x=0; x<n*2; x++) {
				for(int y=0; y<n*2; y++) {
					for(int i=0; i<m; i++) {
						for(int j=0; j<m; j++) {
							newLock[i+x][j+y] += key[i][j];
						}
					}
					
					if(check(newLock))	return true;
					
					for(int i=0; i<m; i++) {
						for(int j=0; j<m; j++) {
							newLock[i+x][j+y] -= key[i][j];
						}
					}
				}
			}
		}
		return false;
		
	}
}

package com.ssafy.review0105;

import java.awt.geom.Area;
import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = {10};
        int min = Integer.MAX_VALUE;
       int num = arr.length;
       System.out.println(num);
       for(int i=0; i<arr.length; i++){
           list.add(arr[i]);
            min = Math.min(min, arr[i]);
       }
       System.out.println(min);
	}
}

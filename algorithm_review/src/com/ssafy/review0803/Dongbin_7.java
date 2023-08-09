package com.ssafy.review0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = input.length();
        int left = 0;
        int right = 0;
        for(int i=0; i<length/2; i++){
            left += Integer.parseInt(input.substring(i, i+1));
        }

        for(int i=length/2; i<length; i++){
            right +=  Integer.parseInt(input.substring(i, i+1));
        }

        if(right == left) System.out.println("LUCKY");
        else System.out.println("READY");


    }
}

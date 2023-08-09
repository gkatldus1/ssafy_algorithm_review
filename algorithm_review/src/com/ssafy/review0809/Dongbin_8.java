package com.ssafy.review0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;

public class Dongbin_8 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sum = 0;
        String alphabet = "";
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i=0; i<input.length(); i++){
            char now = input.charAt(i);
            if(Character.isAlphabetic(now)) arrayList.add(input.substring(i, i+1));
            else sum += Integer.parseInt(input.substring(i, i+1));

        }
        Collections.sort(arrayList);
        for(int i=0; i< arrayList.size(); i++)  alphabet += arrayList.get(i);

        alphabet += sum;

        System.out.println(alphabet);
    }


}

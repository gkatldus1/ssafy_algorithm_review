package com.ssafy.review0814;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = s.length();

        for(int i=1; i<s.length()/2+1; i++){
            String compressed = "";

            String prev = s.substring(0, i);
            int count = 1;

            for(int j=i; j<s.length(); j+=i){

                String sub = "";
                for(int k=j; k<j+i; k++){
                    if(k < s.length()) sub += s.charAt(k);
                }

                if(prev.equals(sub)){
                    count += 1;
                }
                else {
                    int temp_cnt = count;
                    if(temp_cnt >= 2) compressed += temp_cnt + prev;
                    else    compressed += prev;

                    prev = sub;
                    count = 1;
                }

            }

            int temp_cnt = count;
            if(temp_cnt >= 2) compressed += temp_cnt + prev;
            else    compressed += prev;

            answer = Math.min(answer, compressed.length());

        }

        System.out.println(answer);

    }


}

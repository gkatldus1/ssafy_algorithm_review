package com.ssafy.review0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dongbin_18 {
    //균형잡힌 문자열 인덱스 반환
    static int balancedIndex(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;

            if(count == 0)  return i;   //0이면 괄호 짝이 맞으므로 인덱스 리턴


        }

        return -1;
    }

    //올바른 괄호 문자열인지 판단
    static boolean checkProper(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else{
                if(count == 0) return false;    //빼야할때 이미 0이면 올바른 괄호가 아니므로
                count--;
            }
        }
        return true;    //원래는 여기서 제대로 된 괄호인지 한번 더 체크해야하나 받은 인자값이 처음부터 균형 괄호이므로 체크 안한다.
    }


    static String solution(String p) {
        String answer = "";

        if(p.equals(""))   return answer;

        int index = balancedIndex(p);

        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if(checkProper(u)) answer = u + solution(v);    //u가 올바른 괄호일때
        else{   //아닐때는 문제 설명대로 구현해줌
            answer = "(";
            answer += solution(v);
            answer += ")";


            String now = "";

            for (int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(') now += ")";
                else now += "(";
            }
            answer += now;

        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String p = br.readLine();


        System.out.println(solution(p));


    }


}

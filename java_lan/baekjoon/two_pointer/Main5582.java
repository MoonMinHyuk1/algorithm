package java_lan.baekjoon.two_pointer;

import java.util.*;
import java.io.*;

public class Main5582 {

    public static int solution(String s1, String s2) {
        int answer = 0;
        int lt = 0, rt = 1;

        while(lt <= rt && lt < s2.length() && rt <= s2.length()) {
            String s = s2.substring(lt, rt);
            if(s1.contains(s)) {
                answer = Math.max(answer, rt - lt);
                rt++;
            } else {
                lt++;
                if(lt >= rt) {
                    rt++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }
}

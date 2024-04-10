package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main17609 {

    public static int solution(String str) {
        StringBuilder sb = new StringBuilder(str);

        if(sb.reverse().toString().equals(str)) {
            return 0;
        }
        int lt = 0, rt = str.length() - 1;
        while(lt <= rt) {

            if(str.charAt(lt) != str.charAt(rt)) {
                StringBuilder left = new StringBuilder(str).deleteCharAt(lt);
                StringBuilder right = new StringBuilder(str).deleteCharAt(rt);

                if(left.toString().equals(left.reverse().toString()) ||
                        right.toString().equals(right.reverse().toString())) {
                    return 1;
                }
                break;
            }

            lt++;
            rt--;
        }

        return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(solution(str)).append("\n");
        }

        System.out.println(sb);
    }
}

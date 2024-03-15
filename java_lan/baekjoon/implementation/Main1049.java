package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int six = Integer.MAX_VALUE, one = Integer.MAX_VALUE;
        int quotient = n / 6;
        int remainder = n % 6;
        for(int i = 0; i < arr.length; i++) {
            six = Math.min(six, arr[i][0]);
            one = Math.min(one, arr[i][1]);
        }
        if(six < one * 6) {
            answer += (quotient * six);
            if(six < one * remainder) {
                answer += six;
            } else {
                answer += (remainder * one);
            }
        } else {
            answer += (n * one);
        }

        System.out.println(answer);
    }
}

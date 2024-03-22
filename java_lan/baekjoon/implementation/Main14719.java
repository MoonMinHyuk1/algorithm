package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[m];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            int left = 0, right = 0;
            for(int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for(int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }
            int min = Math.min(left, right);
            if(min > arr[i]) {
                answer += (min - arr[i]);
            }
        }

        System.out.println(answer);
    }
}

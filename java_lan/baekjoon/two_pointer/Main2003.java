package java_lan.baekjoon.two_pointer;

import java.util.*;
import java.io.*;

public class Main2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int s = 0, sum = 0;
        for(int e = 0; e < n; e++) {
            sum += arr[e];
            if(sum == m) {
                answer++;
            } else if(sum > m) {
                while(sum > m && s < e) {
                    sum -= arr[s];
                    s++;
                }
                if(sum == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

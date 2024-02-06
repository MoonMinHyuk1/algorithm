package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] answer = new long[2];
        int lt = 0, rt = n - 1;
        long min = Long.MAX_VALUE;
        while(lt < rt) {
            long sum = arr[lt] + arr[rt];
            if(Math.abs(sum) < min) {
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                min = Math.abs(sum);
            }
            if(sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}

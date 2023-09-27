package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dpi = new int[n];
        int[] dpd = new int[n];

        for(int i = 0; i < arr.length; i++) {
            dpi[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    dpi[i] = Math.max(dpi[i], dpi[j] + 1);
                }
            }
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            dpd[i] = 1;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    dpd[i] = Math.max(dpd[i], dpd[j] + 1);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dpi[i] + dpd[i]);
        }

        System.out.println(answer - 1);
    }
}
//가장 긴 바이토닉 부분 수열
package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[10001];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[arr[i]]++;
        }

        int[] answer = new int[n];
        for(int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = --sum[num];
            answer[index] = num;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }
}

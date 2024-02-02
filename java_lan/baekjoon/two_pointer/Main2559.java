package java_lan.baekjoon.two_pointer;

import java.util.*;
import java.io.*;

public class Main2559 {

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

        int s = 0, sum = 0, answer = 0;
        for(int i = 0; i < m; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i = m; i < n; i++) {
            sum += arr[i];
            sum -= arr[s];
            s++;
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}

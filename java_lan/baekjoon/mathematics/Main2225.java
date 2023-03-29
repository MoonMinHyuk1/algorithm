package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main2225 {
    static int n, k;
    static long answer;

    public static void solution() {
        long[][] arr = new long[k][n + 1];

        for(int i = 0; i <= n; i++) {
            arr[0][i] = 1;
        }
        for(int i = 0; i < k; i++) {
            arr[i][0] = 1;
        }
        for(int i = 1; i < k; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;
            }
        }

        answer = arr[k - 1][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = 0;
        solution();
        sb.append(answer);

        System.out.println(sb);
    }
}

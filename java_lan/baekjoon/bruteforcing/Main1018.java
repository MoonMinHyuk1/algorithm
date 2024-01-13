package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1018 {

    public static int solution(char[][] array, int x, int y) {
        int cnt = 0;
        char[][] arr = new char[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                arr[i][j] = array[i + x][j + y];
            }
        }
        char c = arr[0][0];
        for(int i = 0; i < 8; i += 2) {
            for(int j = 0; j < 8; j += 2) {
                if(arr[i][j] != c) cnt++;
            }
        }
        for(int i = 1; i < 8; i += 2) {
            for(int j = 1; j < 8; j += 2) {
                if(arr[i][j] != c) cnt++;
            }
        }
        for(int i = 0; i < 8; i += 2) {
            for(int j = 1; j < 8; j += 2) {
                if(arr[i][j] == c) cnt++;
            }
        }
        for(int i = 1; i < 8; i += 2) {
            for(int j = 0; j < 8; j += 2) {
                if(arr[i][j] == c) cnt++;
            }
        }

        return Math.min(cnt, 64 - cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, solution(arr, i, j));
            }
        }

        System.out.println(answer);
    }
}

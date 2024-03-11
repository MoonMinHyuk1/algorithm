package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main2096 {

    public static int[] solution(int n, int[][] arr) {
        int[] answer = new int[2];
        int[][] min = new int[n][3];
        int[][] max = new int[n][3];
        int[] dj = {-1, 0, 1};

        min[0] = arr[0];
        max[0] = arr[0];
        for(int i = 1; i < n; i++) {
            Arrays.fill(min[i], 1000000);
            Arrays.fill(max[i], 0);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    int pj = j + dj[k];
                    if(pj >= 0 && pj < 3) {
                        min[i][j] = Math.min(min[i][j], arr[i][j] + min[i - 1][pj]);
                        max[i][j] = Math.max(max[i][j], arr[i][j] + max[i - 1][pj]);
                    }
                }
            }
        }

        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            answer[0] = Math.max(answer[0], max[n - 1][i]);
            answer[1] = Math.min(answer[1], min[n - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = solution(n, arr);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

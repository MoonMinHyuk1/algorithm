package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main14889 {

    static int answer;
    static Set<Integer> index;

    public static void combination(int n, int[][] arr, int s, int level, int r) {
        if(level == r) {
            int t1 = 0, t2 = 0;
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    if(i != j && index.contains(i) && index.contains(j)) {
                        t1 += arr[i][j];
                    }
                    if(i != j && !index.contains(i) && !index.contains(j)) {
                        t2 += arr[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(t1 - t2));
            return;
        }
        for(int i = s; i < n; i++) {
            index.add(i);
            combination(n, arr, i + 1, level + 1, r);
            index.remove(i);
        }
    }

    public static int solution(int n, int[][] arr) {
        answer = Integer.MAX_VALUE;
        index = new HashSet<>();
        index.add(0);
        combination(n, arr, 1, 1, n / 2);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));
    }
}

package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main1011 {
    static int answer;
    static int x, y;

    public static void dfs(int k, int sum, int level) {
        if(answer != 0 || sum > y) {
            return;
        }
        if(sum == y && k == 1) {
            answer = level;
            return;
        }
        dfs(k + 1, sum + k, level + 1);
        dfs(k, sum + k, level + 1);
        if(k - 1 > 0) {
            dfs(k - 1, sum + k, level + 1);
        }
    }

    public static void solution() {
        int dis = y - x;
        int sqrt = (int) Math.sqrt(dis);
        
        if(sqrt * sqrt == dis) {
            answer = 2 * sqrt - 1;
        } else if(sqrt * sqrt + sqrt < dis) {
            answer = 2 * sqrt + 1;
        } else {
            answer = 2 * sqrt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // answer = 0;
            // dfs(1, x + 1, 1);
            solution();
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}

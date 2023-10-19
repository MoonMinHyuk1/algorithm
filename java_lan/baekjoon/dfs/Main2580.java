package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main2580 {

    static boolean flag;

    public static boolean check(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 0) return false;
            }
        }

        return true;
    }

    public static boolean duplicate(int x, int y, int[][] arr, int v) {
        //가로
        for(int i = 0; i < arr.length; i++) {
            if(arr[x][i] == v) return false;
        }

        //세로
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][y] == v) return false;
        }

        //정사각형
        int si = (x / 3) * 3, sj = (y / 3) * 3;
        for(int i = si; i < si + 3; i++) {
            for(int j = sj; j < sj + 3; j++) {
                if(arr[i][j] == v) return false;
            }
        }

        return true;
    }

    public static void dfs(int x, int y, int[][] arr) {
        if(flag) return;
        if(y == 9) {
            dfs(x + 1, 0, arr);
            return;
        }
        if(x == 9) {
            flag = check(arr);
            return;
        }
        if(arr[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(duplicate(x, y, arr, i)) {
                    arr[x][y] = i;
                    dfs(x, y + 1, arr);
                    if(flag) return;
                }
                arr[x][y] = 0;
            }
        } else {
            dfs(x, y + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        for(int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        flag = false;
        dfs(0, 0, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.exit(0);
    }
}

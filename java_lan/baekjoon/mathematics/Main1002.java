package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main1002 {

    public static int solution(int[] arr) {
        if(arr[0] == arr[3] && arr[1] == arr[4] && arr[2] == arr[5]) {
            return -1;
        }
        double d = Math.sqrt(Math.pow(arr[0] - arr[3], 2) + Math.pow(arr[1] - arr[4], 2));
        double r1 = Math.max(arr[2], arr[5]);
        double r2 = Math.min(arr[2], arr[5]);
        if(r1 - r2 < d && d < r1 + r2) {
            return 2;
        }
        if(r1 + r2 == d || r1 - r2 == d) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[6];
            for(int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(solution(arr)).append("\n");
        }
        System.out.println(sb);
    }
}

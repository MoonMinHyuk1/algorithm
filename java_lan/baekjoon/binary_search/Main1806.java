package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = 0, lt = 0, rt = 0;
        while(lt <= n && rt <= n) {
            if(sum >= s) {
                answer = Math.min(answer, rt - lt);
                sum -= arr[lt];
                lt++;
            } else {
                sum += arr[rt];
                rt++;
            }
        }
        answer = (answer == Integer.MAX_VALUE) ? 0 : answer;

        System.out.println(answer);
    }
}

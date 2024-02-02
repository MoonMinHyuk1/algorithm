package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main1654 {

    public static long solution(long[] arr, int n, long max) {
        long answer = 0;
        long lt = 1, rt = max;

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }
            if(cnt >= n) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        long max = Long.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(solution(arr, n, max));
    }
}

package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main10815 {

    public static int solution(int[] arr, int n) {
        int lt = 0, rt = arr.length - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == n) {
                return 1;
            } else if(arr[mid] < n) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] find = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i = 0; i < m; i++) {
            sb.append(solution(arr, find[i])).append(" ");
        }
        System.out.println(sb);
    }
}

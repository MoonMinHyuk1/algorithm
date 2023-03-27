package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main1920 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] ln, lm;

    public static void search(int num) {
        int lt = 0, rt = n - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(ln[mid] == num) {
                sb.append("1\n");
                return;
            } else if(ln[mid] > num) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        sb.append("0\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ln = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            ln[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        lm = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            lm[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ln);
        for(int i = 0; i < m; i++) {
            search(lm[i]);
        }
        
        System.out.println(sb);
    }
}

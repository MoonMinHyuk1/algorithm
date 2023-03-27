package java_lan.baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main2110 {
    static int n, c;
    static int[] l;

    public static int solution() {
        int lt = 1, rt = l[n - 1] - l[0] + 1;
        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, last = l[0];
            for(int i = 1; i < n; i++) {
                if(l[i] - last >= mid) {
                    last = l[i];
                    cnt++;
                }
                if(cnt >= c) {
                    break;
                }
            }
            if(cnt >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        l = new int[n];
        for(int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(l);
        sb.append(solution());

        System.out.println(sb);
    }
}

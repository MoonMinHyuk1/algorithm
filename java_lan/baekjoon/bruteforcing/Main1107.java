package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = Math.abs(n - 100);
        int cnt = 0;
        while(true) {
            int l = n - cnt;
            int r = n + cnt;

            int lcnt = cnt + String.valueOf(l).length();
            int rcnt = cnt + String.valueOf(r).length();
            if(answer < lcnt && answer < rcnt) {
                break;
            }

            if(l >= 0) {
                boolean can = true;
                for(char c: String.valueOf(l).toCharArray()) {
                    if(set.contains(c - '0')) {
                        can = false;
                        break;
                    }
                }
                if(can) {
                    answer = Math.min(answer, lcnt);
                    break;
                }
            }

            boolean can = true;
            for (char c : String.valueOf(r).toCharArray()) {
                if (set.contains(c - '0')) {
                    can = false;
                    break;
                }
            }
            if(can) {
                answer = Math.min(answer, rcnt);
                break;
            }

            cnt++;
        }

        System.out.println(answer);
    }
}

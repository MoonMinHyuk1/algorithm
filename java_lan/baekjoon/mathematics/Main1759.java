package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main1759 {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] l;
    static int[] comb;

    public static void checkCode() {
        char[] code = new char[L];
        int cnt = 0;
        
        for(int i = 0; i < L; i++) {
            code[i] = l[comb[i]];
        }
        for(int i = 0; i < L; i++) {
            switch(code[i]) {
                case 'a': cnt++; break;
                case 'e': cnt++; break;
                case 'i': cnt++; break;
                case 'o': cnt++; break;
                case 'u': cnt++; break;
            }
        }

        if(cnt >=1 && (L - cnt) >= 2) {
            for(int i = 0; i < L; i++) {
                sb.append(code[i]);
            }
            sb.append("\n");
        }
    }

    public static void combination(int index, int level) {
        if(level == L) {
            checkCode();
        } else if(level < L) {
            for(int i = index; i < C; i++) {
                comb[level] = i;
                combination(i + 1, level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        l = new char[C];
        comb = new int[L];
        for(int i = 0; i < C; i++) {
            l[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(l);

        combination(0, 0);
        System.out.println(sb);
    }
}
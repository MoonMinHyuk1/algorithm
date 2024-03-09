package java_lan.baekjoon.hash;

import java.util.*;
import java.io.*;

public class Main14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for(int i = 0; i < m; i++) {
            if(set.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

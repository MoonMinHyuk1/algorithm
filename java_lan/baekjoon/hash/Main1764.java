package java_lan.baekjoon.hash;

import java.util.*;
import java.io.*;

public class Main1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }
        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            if(set.contains(str)) {
                list.add(str);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(String str: list) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}

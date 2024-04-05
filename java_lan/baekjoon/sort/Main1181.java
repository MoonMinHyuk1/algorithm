package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(String s: set) {
            list.add(s);
        }
        Collections.sort(list, (o1, o2) -> (
                (o1.length() == o2.length()) ?
                        o1.compareTo(o2) : o1.length() - o2.length()
        ));

        StringBuilder sb = new StringBuilder();
        for(String s: list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}

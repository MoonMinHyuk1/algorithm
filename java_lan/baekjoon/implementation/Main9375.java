package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main9375 {

    static int answer;
    static int[] index;

    public static void combination(List<Integer> list, int level, int depth, int s, boolean[] visited) {
        if(level == depth) {
            int mul = 1;
            for(int i: index) {
                mul *= list.get(i);
            }
            answer += mul;

            return;
        }
        for(int i = s; i < list.size(); i++) {
            if(!visited[depth]) {
                visited[depth] = true;
                index[depth] = i;
                combination(list, level, depth + 1,i + 1, visited);
                visited[depth] = false;
            }
        }
    }

    public static int solution(int n, String[] arr) {
        answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String str: arr) {
            String[] split = str.split(" ");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int value: map.values()) {
            answer *= (value + 1);
//            list.add(value);
        }
//        for(int i = 0; i < list.size(); i++) {
//            index = new int[i + 1];
//            boolean[] visited = new boolean[i + 1];
//            combination(list, index.length, 0, 0, visited);
//        }

        return answer - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            sb.append(solution(n, arr)).append("\n");
        }

        System.out.println(sb);
    }
}

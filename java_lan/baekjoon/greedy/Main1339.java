package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        Map<Character, Integer> map = new HashMap<>();

        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            int num = 1;
            for(int j = arr[i].length() - 1; j >= 0; j--) {
                char c = arr[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + num);
                num *= 10;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int val: map.values()) {
            list.add(val);
        }
        Collections.sort(list, Collections.reverseOrder());
        int mul = 9;
        for(int num: list) {
            answer += (num * mul);
            mul--;
        }

        System.out.println(answer);
    }
}

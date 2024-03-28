package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[4];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0, max = 0;

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i]) > max) {
                list.clear();
                list.add(arr[i]);
                max = map.get(arr[i]);
            } else if(map.get(arr[i]) == max) {
                list.add(arr[i]);
            }
        }
        answer[0] = Math.round((float) sum / n);
        answer[1] = arr[n / 2];
        answer[2] = (list.size() == 1) ? list.get(0) : list.get(1);
        answer[3] = arr[arr.length - 1] - arr[0];

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}

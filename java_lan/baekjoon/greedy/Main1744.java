package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = 0, index = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < arr.length; i++) {
            index = i;
            if(arr[i] > 0) break;
        }
        for(int i = 0; i < index; i += 2) {
            if((i + 1 >= arr.length) || (arr[i] > 0 || arr[i + 1] > 0)) break;
            answer += (arr[i] * arr[i + 1]);
            visited[i] = true;
            visited[i + 1] = true;
        }
        for(int i = arr.length - 1; i >= index; i -= 2) {
            if((i - 1 < 0) || (arr[i] <= 1 || arr[i - 1] <= 1)) break;
            answer += (arr[i] * arr[i - 1]);
            visited[i] = true;
            visited[i - 1] = true;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) answer += arr[i];
        }

        System.out.println(answer);
    }
}

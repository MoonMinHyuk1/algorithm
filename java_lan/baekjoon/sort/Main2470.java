package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int lt = 0, rt = arr.length - 1;
        while(lt < rt) {
            int abs = Math.abs(arr[lt] + arr[rt]);
            if(abs < sum) {
                sum = abs;
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                if(abs == 0) break;
            }
            if(arr[lt] + arr[rt] < 0) {
                lt++;
            } else if(arr[lt] + arr[rt] > 0) {
                rt--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

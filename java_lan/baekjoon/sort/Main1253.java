package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            int lt = 0, rt = arr.length - 1;
            while(lt < rt) {
                if(lt == i) {
                    lt++;
                    continue;
                }
                if(rt == i) {
                    rt--;
                    continue;
                }

                int sum = arr[lt] + arr[rt];
                if(sum == arr[i]) {
                    answer++;
                    break;
                } else if(sum > arr[i]) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }

        System.out.println(answer);
    }
}

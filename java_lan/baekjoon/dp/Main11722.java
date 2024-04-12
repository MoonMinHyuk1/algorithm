package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < n; i++) {
            if(list.get(list.size() - 1) > arr[i]) {
                list.add(arr[i]);
                continue;
            }
            int lt = 0, rt = list.size() - 1;
            while(lt < rt) {
                int mid = (lt + rt) / 2;
                if(list.get(mid) > arr[i]) {
                    lt = mid + 1;
                } else {
                    rt = mid;
                }
            }
            list.set(rt, arr[i]);
        }
        answer = list.size();

        System.out.println(answer);
    }
}

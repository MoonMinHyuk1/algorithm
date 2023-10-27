package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int lt = 0, rt = list.size() - 1;
                while (lt <= rt) {
                    int mid = (lt + rt) / 2;
                    if(list.get(mid) < arr[i]) {
                        lt = mid + 1;
                    } else {
                        rt = mid - 1;
                    }
                }
                list.set(lt, arr[i]);
            }
        }

        System.out.println(list.size());
    }
}

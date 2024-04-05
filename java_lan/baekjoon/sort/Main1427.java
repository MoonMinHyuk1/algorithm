package java_lan.baekjoon.sort;

import java.util.*;
import java.io.*;

public class Main1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}

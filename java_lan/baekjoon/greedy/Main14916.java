package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int share = n / 5;
        while(share >= 0) {
            int remainder = n - (share * 5);
            if(remainder % 2 == 0) {
                answer += (share + remainder / 2);
                break;
            }
            share--;
        }
        if(share < 0) {
            answer = -1;
        }

        System.out.println(answer);
    }
}

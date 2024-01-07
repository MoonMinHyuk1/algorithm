package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Set<String> set = new HashSet<>(List.of(arr));
        int answer = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '=' && i > 1 && str.charAt(i - 1) == 'z' && str.charAt(i - 2) == 'd') {
                answer--;
                continue;
            }
            if(c == 'j' && i > 0 && (str.charAt(i - 1) == 'l' || str.charAt(i - 1) == 'n')) continue;
            if(c == '-' || c == '=') continue;
            answer++;
        }

        System.out.println(answer);
    }
}

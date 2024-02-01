package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main8911 {

    public static int solution(String str) {
        int answer = 0;
        int x = 0, y = 0;
        int minx = 0, maxx = 0;
        int miny = 0, maxy = 0;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int index = 0;

        for(char c: str.toCharArray()) {
            switch (c) {
                case 'L': {
                    index = (index + 1) % 4;
                    break;
                }
                case 'R': {
                    index--;
                    if(index < 0) index = 3;
                    break;
                }
                case 'F': {
                    x += dx[index];
                    y += dy[index];
                    maxx = Math.max(maxx, x);
                    minx = Math.min(minx, x);
                    maxy = Math.max(maxy, y);
                    miny = Math.min(miny, y);
                    break;
                }
                case 'B': {
                    x -= dx[index];
                    y -= dy[index];
                    maxx = Math.max(maxx, x);
                    minx = Math.min(minx, x);
                    maxy = Math.max(maxy, y);
                    miny = Math.min(miny, y);
                    break;
                }
            }
        }
        answer = (maxx - minx) * (maxy - miny);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(solution(str)).append("\n");
        }
        System.out.println(sb);
    }
}

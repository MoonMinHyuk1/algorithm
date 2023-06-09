package dfs;

import java.util.*;

public class Main6_3 {

    int n, answer, white, black;

    public void dfs(int level, int s, int w, int b, int[][] cans) {
        if(level == n / 2) {
            answer = Math.min(answer, Math.abs(w - (black - b)));
            return;
        }
        for(int i = s; i < n; i++) {
            dfs(level + 1, i + 1, w + cans[i][0], b + cans[i][1], cans);
        }
    }

    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        n = cans.length;
        white = 0;
        black = 0;

        for(int i = 0; i < cans.length; i++) {
            white += cans[i][0];
            black += cans[i][1];
        }
        dfs(0, 0, 0, 0, cans);

        return answer;
    }

    public static void main(String[] args){
        Main6_3 T = new Main6_3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}

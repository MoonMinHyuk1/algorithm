package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main14499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[] move = new int[k];
        for(int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < move.length; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int[] dice = new int[6];
        //0 - 위, 1 - 아래, 2 - 오른쪽, 3 - 왼쪽, 4 - 앞쪽, 5 - 뒤쪽
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < move.length; i++) {
            int direction = move[i] - 1;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(direction == 0) {    //오른쪽
                int[] temp = Arrays.copyOf(dice, dice.length);
                dice[0] = temp[3];
                dice[1] = temp[2];
                dice[2] = temp[0];
                dice[3] = temp[1];
                dice[4] = temp[4];
                dice[5] = temp[5];
                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[1];
                } else {
                    dice[1] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                sb.append(dice[0]).append("\n");
            } else if(direction == 1) { //왼쪽
                int[] temp = Arrays.copyOf(dice, dice.length);
                dice[0] = temp[2];
                dice[1] = temp[3];
                dice[2] = temp[1];
                dice[3] = temp[0];
                dice[4] = temp[4];
                dice[5] = temp[5];
                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[1];
                } else {
                    dice[1] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                sb.append(dice[0]).append("\n");
            } else if(direction == 2) { //뒤쪽
                int[] temp = Arrays.copyOf(dice, dice.length);
                dice[0] = temp[4];
                dice[1] = temp[5];
                dice[2] = temp[2];
                dice[3] = temp[3];
                dice[4] = temp[1];
                dice[5] = temp[0];
                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[1];
                } else {
                    dice[1] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                sb.append(dice[0]).append("\n");
            } else if(direction == 3) { //앞쪽
                int[] temp = Arrays.copyOf(dice, dice.length);
                dice[0] = temp[5];
                dice[1] = temp[4];
                dice[2] = temp[2];
                dice[3] = temp[3];
                dice[4] = temp[0];
                dice[5] = temp[1];
                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[1];
                } else {
                    dice[1] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                sb.append(dice[0]).append("\n");
            }
            x = nx;
            y = ny;
        }

        System.out.println(sb);
    }
}

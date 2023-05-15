package simulation_implementation;

import java.util.*;

public class Main1_7 {

    public int solution(int[] keypad, String password){
        int answer = 0;
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        int[][] pad = new int[3][3];
        int[] pw = new int[password.length()];
        int[] point = new int[2];

        for(int i = 0; i < pw.length; i++) {
            pw[i] = password.charAt(i) - '0';
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                pad[i][j] = keypad[(i * 3) + j];
                if(pad[i][j] == pw[0]) {
                    point[0] = i;
                    point[1] = j;
                }
            }
        }
        for(int i = 1; i < pw.length; i++) {
            boolean change = false;
            if(pw[i] == pad[point[0]][point[1]]) continue;
            for(int j = 0; j < 8; j++) {
                int nx = point[0] + dx[j];
                int ny = point[1] + dy[j];
                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3 && pad[nx][ny] == pw[i]) {
                    change = true;
                    point[0] = nx;
                    point[1] = ny;
                    answer += 1;
                    break;
                }
            }
            if(!change) {
                answer += 2;
                for(int j = 0; j < 3; j++) {
                    for(int k = 0; k < 3; k++) {
                        if(pad[j][k] == pw[i]) {
                            point[0] = j;
                            point[1] = k;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public int refactor(int[] keypad, String password) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        int[] pw = new int[password.length()];

        for(int i = 0; i < pw.length; i++) {
            pw[i] = password.charAt(i) - '0';
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                pad[i][j] = keypad[(i * 3) + j];
            }
        }
        for(int i = 1; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int a = pad[i][j];
                dist[a][a] = 0;
                for(int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int b = pad[nx][ny];
                        dist[a][b] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < pw.length - 1; i++) {
            answer += dist[pw[i]][pw[i + 1]];
        }

        return answer;
    }

    public static void main(String[] args){
        Main1_7 T = new Main1_7();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
        System.out.println(T.refactor(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.refactor(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.refactor(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.refactor(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}

package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main15683 {

    static int answer;
    static List<int[]> list;

    public static void right(int x, int y, int[][] arr, List<int[]> change) {
        for(int i = y + 1; i < arr[x].length; i++) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] == 0) {
                arr[x][i] = -1;
                change.add(new int[]{x, i});
            }
        }
    }

    public static void left(int x, int y, int[][] arr, List<int[]> change) {
        for(int i = y - 1; i >= 0; i--) {
            if(arr[x][i] == 6) break;
            if(arr[x][i] == 0) {
                arr[x][i] = -1;
                change.add(new int[]{x, i});
            }
        }
    }

    public static void up(int x, int y, int[][] arr, List<int[]> change) {
        for(int i = x - 1; i >= 0; i--) {
            if(arr[i][y] == 6) break;
            if(arr[i][y] == 0) {
                arr[i][y] = -1;
                change.add(new int[]{i, y});
            }
        }
    }

    public static void down(int x, int y, int[][] arr, List<int[]> change) {
        for(int i = x + 1; i < arr.length; i++) {
            if(arr[i][y] == 6) break;
            if(arr[i][y] == 0) {
                arr[i][y] = -1;
                change.add(new int[]{i, y});
            }
        }
    }

    public static void dfs(int level, int[][] arr) {
        if(level == list.size()) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 0) sum++;
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        List<int[]> change = new ArrayList<>();
        int[] now = list.get(level);
        int x = now[0], y = now[1];
        if(arr[x][y] == 1) {
            //오른쪽
            right(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //왼쪽
            change.clear();
            left(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //위
            change.clear();
            up(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //아래
            change.clear();
            down(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
        } else if(arr[x][y] == 2) {
            //왼오
            left(x, y, arr, change);
            right(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //위아래
            change.clear();
            up(x, y, arr, change);
            down(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
        } else if(arr[x][y] == 3) {
            //위오
            up(x, y, arr, change);
            right(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //오아래
            change.clear();
            right(x, y, arr, change);
            down(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //왼아래
            change.clear();
            left(x, y, arr, change);
            down(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //왼위
            change.clear();
            left(x, y, arr, change);
            up(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
        } else if(arr[x][y] == 4) {
            //왼위오
            left(x, y, arr, change);
            up(x, y, arr, change);
            right(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //위오아래
            change.clear();
            up(x, y, arr, change);
            right(x, y, arr, change);
            down(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //오아래왼
            change.clear();
            right(x, y, arr, change);
            down(x, y, arr, change);
            left(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
            //아래왼위
            change.clear();
            down(x, y, arr, change);
            left(x, y, arr, change);
            up(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
        } else if(arr[x][y] == 5) {
            //위오아래왼
            up(x, y, arr, change);
            right(x, y, arr, change);
            down(x, y, arr, change);
            left(x, y, arr, change);
            dfs(level + 1, arr);
            for(int[] c: change) {
                arr[c[0]][c[1]] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    list.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0, arr);

        System.out.println(answer);
    }
}

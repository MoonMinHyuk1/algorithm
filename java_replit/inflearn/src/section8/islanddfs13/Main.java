package section8.islanddfs13;

import java.util.Scanner;

public class Main {
    static int[][] G, ch;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int n, answer = 0;

    public void DFS(int x, int y) {
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(G[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        G = new int[n][n];
        ch = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(G[i][j] == 1 && ch[i][j] == 0) {
                    A.DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

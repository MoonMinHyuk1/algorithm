package section8.mazesearchdfs10;

import java.util.Scanner;

public class Main {
    static int[][] G, ch;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public void DFS(int x, int y) {
        if(x == 6 && y == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ((nx >= 0) && (nx < 7) && (ny >= 0) && (ny < 7)) {
                    if ((ch[nx][ny] == 0) && (G[nx][ny] == 0)) {
                        ch[nx][ny] = 1;
                        DFS(nx, ny);
                        ch[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        G = new int[7][7];
        ch = new int[7][7];
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        ch[0][0] = 1;
        A.DFS(0, 0);
        System.out.println(answer);
    }
}

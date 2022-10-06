package section8.tomato12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, answer = -1;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] G;

    public void BFS() {
        Queue<Point> Q = new LinkedList<Point>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(G[i][j] == 1) {
                    Point p = new Point(i, j);
                    Q.offer(p);
                }
            }
        }
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Point p = Q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if(G[nx][ny] == 0) {
                            Q.offer(new Point(nx, ny));
                            G[nx][ny] = 1;
                        }
                    }
                }
            }
            answer++;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(G[i][j] == 0) {
                    answer = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        G = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        A.BFS();
        System.out.println(answer);
    }
}

import java.util.*;

public class Main1012 {
  static int[][] G, ch;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int t, n, m, k, answer = 0;

  public void DFS(int x, int y) {
    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if(G[nx][ny] == 1) {
          G[nx][ny] = 0;
          DFS(nx, ny);
        }
      }
    }
  }

  public static void main(String[] args) {
    Main1012 A = new Main1012();
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      n = sc.nextInt();
      m = sc.nextInt();
      k = sc.nextInt();
      G = new int[n][m];
      ch = new int[n][m];
      answer = 0;
      for(int j = 0; j < k; j++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        G[a][b] = 1;
      }
      for(int x = 0; x < n; x++) {
        for(int y = 0; y < m; y++) {
          if(G[x][y] == 1) {
            G[x][y] = 0;
            A.DFS(x, y);
            answer++;
          }
        }
      }
      System.out.println(answer);
    }
  }
}
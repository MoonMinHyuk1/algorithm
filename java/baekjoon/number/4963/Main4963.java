import java.util.*;

public class Main4963 {
  static int[][] G;
  static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
  static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
  static int n, m, answer = 0;

  public void DFS(int x, int y) {
    for(int i = 0; i < 8; i++) {
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
    Main4963 A = new Main4963();
    Scanner sc = new Scanner(System.in);

    while(true) {
      answer = 0;
      m = sc.nextInt();
      n = sc.nextInt();
      if(n == 0 && m == 0) {
        break;
      }
      G = new int[n][m];
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          G[i][j] = sc.nextInt();
        }
      }
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          if(G[i][j] == 1) {
            A.DFS(i, j);
            answer++;
          }
        }
      }
      System.out.println(answer);
    }
  }
}
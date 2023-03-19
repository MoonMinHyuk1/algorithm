import java.util.*;

public class Main10026 {
  static int n, answer1 = 0, answer2 = 0;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int[][] ch;
  static char[][] G;

  public void DFS1(int x, int y, char c) {
    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if(G[nx][ny] == c && ch[nx][ny] == 0) {
          ch[nx][ny] = 1;
          DFS1(nx, ny, c);
        }
      }
    }
  }

  public void DFS2(int x, int y, char c) {
    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if(ch[nx][ny] == 0) {
          if(c == 'B') {
            if(G[nx][ny] == 'B') {
              ch[nx][ny] = 1;
              DFS2(nx, ny, c);
            }
          } else if(c == 'R' || c == 'G') {
            if(G[nx][ny] == 'R' || G[nx][ny] == 'G') {
              ch[nx][ny] = 1;
              DFS2(nx, ny, c);
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Main10026 A = new Main10026();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    sc.nextLine();
    G = new char[n][n];
    ch = new int[n][n];
    for(int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for(int j = 0; j < n; j++) {
        G[i][j] = str.charAt(j);
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(ch[i][j] == 0) {
          ch[i][j] = 1;
          A.DFS1(i, j, G[i][j]);
          answer1++;
        }
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        ch[i][j] = 0;
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(ch[i][j] == 0) {
          ch[i][j] = 1;
          A.DFS2(i, j, G[i][j]);
          answer2++;
        }
      }
    }
    System.out.println(answer1 + " " + answer2);
  }
}
import java.util.*;

public class Main2178 {
  static int n, m, answer = 0;
  static int[][] ch;
  static int[][] G;

  static class Coor {
    int a;
    int b;

    public Coor(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public void BFS(int a, int b) {
    Queue<Coor> Q = new LinkedList<>();

    Coor coor = new Coor(a, b);
    Q.offer(coor);
    while(!Q.isEmpty()) {
      int len = Q.size();
      for(int i = 0; i < len; i++) {
        coor = Q.poll();
        int x = coor.a;
        int y = coor.b;

        if(x == n && y == m) {
          return;
        }

        if(ch[x + 1][y] == 0 && G[x + 1][y] == 1) {
          ch[x + 1][y] = 1;
          Q.offer(new Coor(x + 1, y));
        }
        if(ch[x - 1][y] == 0 && G[x - 1][y] == 1) {
          ch[x - 1][y] = 1;
          Q.offer(new Coor(x - 1, y));
        }
        if(ch[x][y + 1] == 0 && G[x][y + 1] == 1) {
          ch[x][y + 1] = 1;
          Q.offer(new Coor(x, y + 1));
        }
        if(ch[x][y - 1] == 0 && G[x][y - 1] == 1) {
          ch[x][y - 1] = 1;
          Q.offer(new Coor(x, y - 1));
        }
      }
      answer++;
    }
  }

  public static void main(String[] args) {
    Main2178 A = new Main2178();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();
    G = new int[n + 2][m + 2];
    ch = new int[n + 2][m + 2];
    for(int i = 1; i <= n; i++) {
      String str = sc.nextLine();
      int index = 1;
      for(char c : str.toCharArray()) {
        G[i][index] = c - '0';
        index++;
      }
    }

    ch[1][1] = 1;
    answer++;
    A.BFS(1, 1);
    System.out.println(answer);
  }
}
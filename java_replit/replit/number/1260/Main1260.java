import java.util.*;

public class Main1260 {
  static int[][] G;
  static int n, m;
  static int[] ch;

  public void DFS(int v) {
    for(int i = 1; i <= n; i++) {
      if(G[v][i] == 1 && ch[i] == 0) {
        System.out.print(i + " ");
        ch[i] = 1;
        DFS(i);
      }
    }
  }

  public void BFS(int v) {
    Queue<Integer> Q = new LinkedList<>();

    Q.offer(v);
    while(!Q.isEmpty()) {
      int len = Q.size();
      for(int i = 0; i < len; i++) {
        int vertex = Q.poll();
        for(int j = 1; j<= n; j++) {
          if(G[vertex][j] == 1 && ch[j] == 0) {
            ch[j] = 1;
            Q.offer(j);
            System.out.print(j + " ");
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Main1260 A = new Main1260();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    int start = sc.nextInt();
    G = new int[n + 1][n + 1];
    ch = new int[n + 1];
    for(int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      G[a][b] = 1;
      G[b][a] = 1;
    }

    System.out.print(start + " ");
    ch[start] = 1;
    A.DFS(start);
    
    System.out.println();
    for(int i = 0; i <= n; i++) {
      ch[i] = 0;
    }
    
    System.out.print(start + " ");
    ch[start] = 1;
    A.BFS(start);
  }
}
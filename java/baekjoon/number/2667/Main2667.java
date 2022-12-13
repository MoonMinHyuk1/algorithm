import java.util.*;

public class Main2667 {
  static int[][] G, ch;
  static ArrayList<Integer> answer = new ArrayList<>();
  static int n, count;

  public void DFS(int x, int y) {
    count++;
    if(G[x + 1][y] == 1 && ch[x + 1][y] == 0) {
      ch[x + 1][y] = 1;
      DFS(x + 1, y);
    }
    if(G[x - 1][y] == 1 && ch[x - 1][y] == 0) {
      ch[x - 1][y] = 1;
      DFS(x - 1, y);
    }
    if(G[x][y + 1] == 1 && ch[x][y + 1] == 0) {
      ch[x][y + 1] = 1;
      DFS(x, y + 1);
    }
    if(G[x][y - 1] == 1 && ch[x][y - 1] == 0) {
      ch[x][y - 1] = 1;
      DFS(x, y - 1);
    }
  }
  
  public static void main(String[] args) {
    Main2667 A = new Main2667();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    sc.nextLine();
    G = new int[n + 2][n + 2];
    ch = new int[n + 2][n + 2];
    for(int i = 1; i <= n; i++) {
      String str = sc.nextLine();
      int index = 1;
      for(char c : str.toCharArray()) {
        G[i][index] = c - '0';
        index++;
      }
    }

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(ch[i][j] == 0 && G[i][j] == 1) {
          ch[i][j] = 1;
          count = 0;
          A.DFS(i, j);
          answer.add(count);
        }
      }
    }
    Collections.sort(answer);
    
    System.out.println(answer.size());
    for(int num : answer) {
      System.out.println(num);
    }
  }
}
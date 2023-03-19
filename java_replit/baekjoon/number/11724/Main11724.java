import java.util.*;

public class Main11724 {
  static int n, m, answer = 0;
  static int[] ch;
  static ArrayList<ArrayList<Integer>> G;

  public void DFS(int v) {
    for(int nv : G.get(v)) {
      if(ch[nv] == 0) {
        ch[nv] = 1;
        DFS(nv);
      }
    }
  }

  public static void main(String[] args) {
    Main11724 A = new Main11724();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    ch = new int[n + 1];
    G = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i <= n; i++) {
      G.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      G.get(a).add(b);
      G.get(b).add(a);
    }

    for(int i = 1; i <= n; i++) {
      if(ch[i] == 0) {
        ch[i] = 1;
        answer++;
        A.DFS(i);
      }
    }
    System.out.println(answer);
  }
}
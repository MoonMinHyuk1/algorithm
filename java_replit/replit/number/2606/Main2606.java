import java.util.*;

public class Main2606 {
  static int n, m, answer = 0;
  static int[] ch;
  static ArrayList<ArrayList<Integer>> G;

  public void BFS(int v) {
    Queue<Integer> Q = new LinkedList<>();

    Q.offer(v);
    while(!Q.isEmpty()) {
      int len = Q.size();
      for(int i = 0; i < len; i++) {
        int cv = Q.poll();
        for(int nv : G.get(cv)) {
          if(ch[nv] == 0) {
            ch[nv] = 1;
            answer++;
            Q.offer(nv);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Main2606 A = new Main2606();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    sc.nextLine();
    m = sc.nextInt();
    sc.nextLine();
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

    ch[1] = 1;
    A.BFS(1);
    System.out.println(answer);
  }
}
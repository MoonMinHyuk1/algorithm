import java.util.*;

public class Main1463 {
  static int n, answer = Integer.MAX_VALUE;

  public void DFS(int L, int sum) {
    if(sum == 1) {
      answer = Math.min(answer, L);
    } else {
      if(sum % 3 == 0) {
        DFS(L + 1, sum / 3);
      }
      if(sum % 2 == 0) {
        DFS(L + 1, sum / 2);
      }
      DFS(L + 1, sum - 1);
    }
  }

  public int BFS() {
    Queue<Integer> Q = new LinkedList<Integer>();
    int L = -1;

    Q.offer(n);
    while(!Q.isEmpty()) {
      int len = Q.size();
      for(int i = 0; i < len; i++) {
        int num = Q.poll();

        if(num == 1) {
          Q.clear();
          break;
        }
        
        if(num % 3 == 0) {
          Q.offer(num / 3);
        }
        if(num % 2 == 0) {
          Q.offer(num / 2);
        }
        Q.offer(num - 1);
      }
      L++;
    }

    return L;
  }
  
  public static void main(String[] args) {
    Main1463 A = new Main1463();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    System.out.println(A.BFS());
    // A.DFS(0, n);
    // System.out.println(answer);
  }
}
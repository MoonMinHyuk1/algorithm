import java.util.*;

public class Main1697 {
  static int n, k, answer = -1;
  static int[] ch;

  public void BFS() {
    Queue<Integer> Q = new LinkedList<>();

    Q.offer(n);
    while(!Q.isEmpty()) {
      int len = Q.size();
      for(int i = 0; i < len; i++) {
        int num = Q.poll();
        if(num == k) {
          Q.clear();
          break;
        }
        if((num - 1 >= 0) && ch[num - 1] == 0) {
          ch[num - 1] = 1;
          Q.offer(num - 1);
        }
        if((num + 1 < 100001) && ch[num + 1] == 0) {
          ch[num + 1] = 1;
          Q.offer(num + 1);
        }
        if((num * 2 < 100001) && ch[num * 2] == 0) {
          ch[num * 2] = 1;
          Q.offer(num * 2);
        }
      }
      answer++;
    }
  }

  public static void main(String[] args) {
    Main1697 A = new Main1697();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    ch = new int[100001];
    ch[n] = 1;
    A.BFS();
    System.out.println(answer);
  }
}
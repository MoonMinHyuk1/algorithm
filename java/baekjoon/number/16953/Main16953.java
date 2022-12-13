import java.util.*;

class Tree {
  long n;
  Tree left, right;
  public Tree(long n) {
    this.n = n;
    this.left = this.right = null;
  }
}

public class Main16953 {
  static long a, b;
  static int answer = 0;
  static Tree tree;

  public void BFS() {
    Queue<Tree> Q = new LinkedList<>();

    Q.offer(tree);
    while(!Q.isEmpty()) {
      int len = Q.size();
      answer++;
      for(int i = 0; i < len; i++) {
        Tree node = Q.poll();
        if(node.n == b) {
          return;
        } else {
          if(node.n * 2 <= b) {
            node.left = new Tree(node.n * 2);
            Q.offer(node.left);
          }
          if(node.n * 10 + 1 <= b) {
            node.right = new Tree(node.n * 10 + 1);
            Q.offer(node.right);
          }
        }
      }
    }

    answer = -1;
  }
  
  public static void main(String[] args) {
    Main16953 A = new Main16953();
    Scanner sc = new Scanner(System.in);

    a = sc.nextLong();
    b = sc.nextLong();
    tree = new Tree(a);
    A.BFS();
    System.out.println(answer);
  }
}
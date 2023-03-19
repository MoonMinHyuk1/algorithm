import java.util.*;

class Node {
  int data;
  ArrayList<Node> child = new ArrayList<>();

  public Node(int data) {
    this.data = data;
  }
}

public class Main1068 {
  Node root;

  public Node findParent(Node node, int data) {
    if(node.data == data) {
      return node;
    }
    for(Node child : node.child) {
      Node parent = findParent(child, data);
      if(parent != null) {
        return parent;
      }
    }

    return null;
  }

  public void findDelete(Node node, int d) {
    for(Node child : node.child) {
      if(child.data == d) {
        node.child.remove(child);
        return;
      }
      findDelete(child, d);
    }
  }

  public int DFS(Node node) {
    if(node.child.size() == 0) {
      return 1;
    }
    int sum = 0;
    for(Node child : node.child) {
      sum += DFS(child);
    }

    return sum;
  }

  public static void main(String[] args) {
    Main1068 tree = new Main1068();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    for(int i = 0; i < n; i++) {
      int data = sc.nextInt();
      if(data == -1) {
        tree.root = new Node(0);
      } else {
        Node parent = tree.findParent(tree.root, data);
        parent.child.add(new Node(i));
      }
    }
    int d = sc.nextInt();
    if(d == 0) {
      System.out.println(0);
    } else {
      tree.findDelete(tree.root, d);
      System.out.println(tree.DFS(tree.root));
    }
  }
}
import java.util.*;

public class Main1991 {
  static Node root;

  static class Node {
    char data;
    Node left, right;
  
    public Node(char data) {
      this.data = data;
      left = right = null;
    }
  }

  public static void insertNode(Node node, char P, char L, char R) {
    if(node == null) {
      return;
    }
    if(node.data == P) {
      if(L != '.') {
        node.left = new Node(L);
      }
      if(R != '.') {
        node.right = new Node(R);
      }
      return;
    }
    insertNode(node.left, P, L, R);
    insertNode(node.right, P, L, R);
  }

  public static void preOrder(Node node) {
    if(node == null) {
      return;
    }
    System.out.print(node.data);
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void inOrder(Node node) {
    if(node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.data);
    inOrder(node.right);
  }

  public static void postOrder(Node node) {
    if(node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data);
  }

  public static void main(String[] args) {
    Main1991 tree = new Main1991();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] arr = new String[n];
    sc.nextLine();
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextLine();
    }
    Arrays.sort(arr);
    for(int i = 0; i < n; i++) {
      char P = arr[i].toCharArray()[0];
      char L = arr[i].toCharArray()[2];
      char R = arr[i].toCharArray()[4];
      if(i == 0) {
        root = new Node(P);
        if(L != '.') {
          root.left = new Node(L);
        }
        if(R != '.') {
          root.right = new Node(R);
        }
      } else {
        insertNode(root, P, L, R);
      }
    }

    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
    System.out.println();
  }
}
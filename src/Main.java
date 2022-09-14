import java.util.*;

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    Node root;

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
        Main tree = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            char P = str.toCharArray()[0];
            char L = str.toCharArray()[2];
            char R = str.toCharArray()[4];
            if(i == 0) {
                tree.root = new Node(P);
                tree.root.left = new Node(L);
                tree.root.right = new Node(R);
            } else {
                insertNode(tree.root, P, L, R);
            }
        }

        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
        System.out.println();
    }
}
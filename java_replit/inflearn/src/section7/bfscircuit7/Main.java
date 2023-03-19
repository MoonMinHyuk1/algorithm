package section7.bfscircuit7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    Node root;

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            Node parent = queue.poll();
            if(parent.left != null) {
                queue.offer(parent.left);
            }
            if(parent.right != null) {
                queue.offer(parent.right);
            }
            System.out.print(parent.data + " ");
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Scanner sc = new Scanner(System.in);

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.BFS(tree.root);
    }
}

package section7.shortestbfs10;

import java.util.LinkedList;
import java.util.Queue;

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

    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int answer = 0;

        if(root.left == null && root.right == null) {
            return 0;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            answer++;
            for(int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        return answer;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.left == null && node.right.right == null) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main tree =  new Main();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }
}

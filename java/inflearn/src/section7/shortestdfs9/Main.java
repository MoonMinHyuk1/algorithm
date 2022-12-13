package section7.shortestdfs9;

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

    public int DFS(Node root, int L) {
        if(root.left == null && root.right == null) {
            return L;
        }

        return Math.min(DFS(root.left, L + 1), DFS(root.right, L + 1));
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.DFS(tree.root, 0));
    }
}

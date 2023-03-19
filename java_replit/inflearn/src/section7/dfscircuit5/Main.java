package section7.dfscircuit5;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {
    Node root;

    public void solution(Node node) {
        if(node == null) {
            return;
        }

//        //전위순회
//        System.out.print(node.data + " ");
//        solution(node.left);
//        solution(node.right);

//        //중위순회
//        solution(node.left);
//        System.out.print(node.data + " ");
//        solution(node.right);

        //후위순회
        solution(node.left);
        solution(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.solution(tree.root);
    }
}

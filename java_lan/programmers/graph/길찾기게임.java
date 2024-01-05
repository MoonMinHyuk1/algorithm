import java.util.*;

class Node {
    int v, x, y;
    Node left, right;
    
    public Node(int v, int x, int y) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    
    int[][] answer;
    int index;
    
    public void preorder(Node node) {
        if(node == null) {
            return;
        }
        answer[0][index++] = node.v;
        preorder(node.left);
        preorder(node.right);
    }
    
    public void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        answer[1][index++] = node.v;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        int[][] arr = new int[nodeinfo.length][3];
        
        for(int i = 0; i < nodeinfo.length; i++) {
            arr[i][0] = nodeinfo[i][0];
            arr[i][1] = nodeinfo[i][1];
            arr[i][2] = i + 1;
        }
        Arrays.sort(arr, (o1, o2) -> ((o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o2[1] - o1[1])));
        Node root = new Node(arr[0][2], arr[0][0], arr[0][1]);
        for(int i = 1; i < arr.length; i++) {
            Node node = root;
            int x = arr[i][0];
            while(true) {
                if(x < node.x) {
                    if(node.left == null) {
                        Node left = new Node(arr[i][2], arr[i][0], arr[i][1]);
                        node.left = left;
                        break;
                    } else {
                        node = node.left;
                    }
                } else if(node.x < x) {
                    if(node.right == null) {
                        Node right = new Node(arr[i][2], arr[i][0], arr[i][1]);
                        node.right = right;
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        index = 0;
        preorder(root);
        index = 0;
        postorder(root);
        
        return answer;
    }
}
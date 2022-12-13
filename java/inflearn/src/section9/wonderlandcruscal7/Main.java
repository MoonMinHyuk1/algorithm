package section9.wonderlandcruscal7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public int v1, v2, cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int v, e;
    static int[] uf;

    public int find(int v) {
        if(v == uf[v]) {
            return v;
        } else {
            return uf[v] = find(uf[v]);
        }
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) {
            uf[fa] = fb;
        }
    }

    public int solution(ArrayList<Node> arr) {
        int answer = 0;

        Collections.sort(arr);
        for(Node node : arr) {
            int fv1 = find(node.v1);
            int fv2 = find(node.v2);
            if(fv1 != fv2) {
                answer += node.cost;
                union(node.v1, node.v2);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        uf = new int[v + 1];
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            uf[i] = i;
        }
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Node(v1, v2, cost));
        }
        System.out.println(A.solution(arr));
    }
}

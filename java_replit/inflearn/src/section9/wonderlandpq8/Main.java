package section9.wonderlandpq8;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public int v, cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int v, e;
    static int[] ch;
    static PriorityQueue<Node> pq;
    static ArrayList<ArrayList<Node>> G;

    public int solution() {
        int answer = 0;
        pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v;
            if(ch[v] == 0) {
                ch[v] = 1;
                answer += node.cost;
                for(Node obj : G.get(v)) {
                    if(ch[obj.v] == 0) {
                        pq.offer(new Node(obj.v, obj.cost));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        ch = new int[v + 1];
        G = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i <= v; i++) {
            G.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            G.get(v1).add(new Node(v2, cost));
            G.get(v2).add(new Node(v1, cost));
        }
        System.out.println(A.solution());
    }
}

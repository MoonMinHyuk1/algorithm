package section9.dijkstra5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> G;
    static int[] ch, dis;
    static int n, m;

    public void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        dis[0] = 0;
        pq.offer(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(ch[node.v] == 0) {
                ch[node.v] = 1;
                for (Node child : G.get(node.v)) {
                    dis[child.v] = Math.min(dis[child.v], dis[node.v] + child.w);
                    pq.offer(new Node(child.v, dis[child.v]));
                }
            }
        }

        for(int i = 1; i < n; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println((i + 1) + " : impossible");
            } else {
                System.out.println((i + 1) + " : " + dis[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        G = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < n; i++) {
            G.add(new ArrayList<Node>());
        }
        ch = new int[n];
        dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            G.get(a - 1).add(new Node(b - 1, c));
        }
        A.solution();
    }
}

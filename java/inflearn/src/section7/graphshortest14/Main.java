package section7.graphshortest14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] ch, answer;
    static ArrayList<ArrayList<Integer>> G;

    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        int dis = 0;

        Q.offer(v);
        ch[v] = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            dis++;
            for(int i = 0; i < len; i++) {
                int cv = Q.poll();
                for(int nv : G.get(cv)) {
                    if(ch[nv] == 0) {
                        ch[nv] = 1;
                        Q.offer(nv);
                        answer[nv] = dis;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        G = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            G.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        answer = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            G.get(a).add(b);
        }
        A.BFS(1);
        for(int i = 2; i <= n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}

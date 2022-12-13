package section7.graphlist13;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> G;

    public void DFS(int v) {
        if(v == n) {
            answer++;
        } else {
            for(int nv : G.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        G = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            G.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            G.get(a).add(b);
        }
        ch[1] = 1;
        A.DFS(1);
        System.out.println(answer);
    }
}

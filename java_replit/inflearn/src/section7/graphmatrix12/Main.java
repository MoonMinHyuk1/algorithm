package section7.graphmatrix12;

import java.util.Scanner;

public class Main {
    static int[][] G;
    static int[] ch;
    static int n, m, answer = 0;

    public void DFS(int v) {
        if(v == n) {
            answer++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(G[v][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        G = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            G[a][b] = 1;
        }
        ch[1] = 1;
        A.DFS(1);
        System.out.println(answer);
    }
}

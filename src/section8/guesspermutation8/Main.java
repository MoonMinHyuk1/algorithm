package section8.guesspermutation8;

import java.util.Scanner;

public class Main {
    static int n, f;
    static int[] com, per, ch;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public int combination(int n, int r) {
        if(dy[n][r] > 0) {
            return dy[n][r];
        }
        if(n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    public void DFS(int L, int sum) {
        if(flag) {
            return;
        }
        if(L == n) {
            if(sum == f) {
                for(int num : per) {
                    System.out.print(num + " ");
                }
                flag = true;
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    per[L] = i;
                    DFS(L + 1, sum + (per[L] * com[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        com = new int[n];
        per = new int[n];
        ch = new int[n + 1];
        for(int i = 0; i < n; i++) {
            com[i] = A.combination(n - 1, i);
        }
        A.DFS(0, 0);
    }
}

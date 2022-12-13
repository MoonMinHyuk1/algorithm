package section8.combination7;

import java.util.Scanner;

public class Main {
    public int DFS(int n, int r) {
        if(r == 1) {
            return n;
        } else if(n == r) {
            return 1;
        } else {
            return DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(A.DFS(n, r));
    }
}

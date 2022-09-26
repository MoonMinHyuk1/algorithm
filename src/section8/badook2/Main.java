package section8.badook2;

import java.util.Scanner;

public class Main {
    static int c, n, answer = 0;

    public void DFS(int L, int sum, int[] arr) {
        if(sum > c) {
            return;
        }
        if(sum >= answer) {
            answer = sum;
        }
        if(L == n) {
            return;
        } else {
            DFS(L + 1, sum, arr);
            DFS(L + 1, sum + arr[L], arr);
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        A.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

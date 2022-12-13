package section8.duppermutation4;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;

    public void DFS(int L) {
        if(L == m) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        A.DFS(0);
    }
}

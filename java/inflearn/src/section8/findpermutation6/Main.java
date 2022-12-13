package section8.findpermutation6;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr, answer, ch;

    public void DFS(int L) {
        if(L == m) {
            for(int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    answer[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        answer = new int[m];
        ch = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        A.DFS(0);
    }
}

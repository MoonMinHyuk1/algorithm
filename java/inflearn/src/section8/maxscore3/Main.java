package section8.maxscore3;

import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;

    public void DFS(int L, int sum, int time, int[][] arr) {
        if(time > m) {
            return;
        }
        if(L == n) {
            if((time <= m) && (sum >= answer)) {
                answer = sum;
            }
        } else {
            DFS(L + 1, sum, time, arr);
            DFS(L + 1, sum + arr[L][0], time + arr[L][1], arr);
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        A.DFS(0, 0, 0, arr);
        System.out.println(answer);
    }
}

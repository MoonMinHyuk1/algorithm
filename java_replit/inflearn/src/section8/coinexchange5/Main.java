package section8.coinexchange5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public void DFS(int L, int sum) {
        if(sum > m || L >= answer) {
            return;
        }
        if(sum == m) {
            if(L < answer) {
                answer = L;
            }
        } else {
            for(int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        A.DFS(0, 0);
        System.out.println(answer);
    }
}

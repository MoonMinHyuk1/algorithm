package section10.stonebridge2;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(A.solution(n));
    }
}

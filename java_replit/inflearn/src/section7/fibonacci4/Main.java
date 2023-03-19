package section7.fibonacci4;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return solution(n - 1) + solution(n - 2);
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            System.out.print(A.solution(i) + " ");
        }
    }
}

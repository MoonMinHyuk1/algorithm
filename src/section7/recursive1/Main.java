package section7.recursive1;

import java.util.Scanner;

public class Main {
    public void solution(int n) {
        if(n == 1) {
            System.out.print(n + " ");

            return;
        }
        solution(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        A.solution(n);
    }
}

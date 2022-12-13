package section7.recursivebinary2;

import java.util.Scanner;

public class Main {
    public void solution(int n) {
        if(n == 0) {
            return;
        }
        solution(n / 2);
        if(n % 2 == 0) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        A.solution(n);
    }
}

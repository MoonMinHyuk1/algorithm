package section7.factorial3;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        if(n == 1) {
            return 1;
        }
        return n * solution(n - 1);
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(A.solution(n));
    }
}

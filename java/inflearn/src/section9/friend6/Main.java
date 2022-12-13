package section9.friend6;

import java.util.Scanner;

public class Main {
    static int[] P;
    static int n, m;

    public int find(int n) {
        if(n == P[n]) {
            return n;
        } else {
            return P[n] = find(P[n]);
        }
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            P[b] = a;
        }
    }

    public String solution(int a, int b) {
        String answer = "NO";

        if(find(a) == find(b)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        P = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            P[i] = i;
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A.union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(A.solution(a, b));
    }
}

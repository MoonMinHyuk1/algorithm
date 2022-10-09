package section8.pizza15;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] C;
    static ArrayList<Point> H, P;

    public void DFS(int s, int L) {
        if(L == m) {
            int sum = 0;
            for(Point p : H) {
                int dis = Integer.MAX_VALUE;
                for(int num : C) {
                    dis = Math.min(dis, Math.abs(p.x - P.get(num).x) + Math.abs(p.y - P.get(num).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s; i < P.size(); i++) {
                C[L] = i;
                DFS(i + 1, L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);
        H = new ArrayList<>();
        P = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        C = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if(num == 1) {
                    H.add(new Point(i, j));
                } else if(num == 2) {
                    P.add(new Point(i, j));
                }
            }
        }
        A.DFS(0, 0);
        System.out.println(answer);
    }
}

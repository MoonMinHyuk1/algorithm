package section10.hightop4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Block implements Comparable<Block> {
    int b, h, w;

    public Block(int b, int h, int w) {
        this.b = b;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Block o) {
        return o.b - this.b;
    }
}

public class Main {
    static int n;
    static int[] dp;
    static ArrayList<Block> arr;

    public int solution() {
        int answer = 0;

        Collections.sort(arr);
        dp[0] = arr.get(0).h;
        answer = arr.get(0).h;
        for(int i = 1; i < n; i++) {
            int maxHeight = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr.get(j).w > arr.get(i).w && maxHeight < dp[j]) {
                    maxHeight = dp[j];
                }
            }
            dp[i] = maxHeight + arr.get(i).h;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n];
        arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Block(b, h, w));
        }
        System.out.println(A.solution());
    }
}

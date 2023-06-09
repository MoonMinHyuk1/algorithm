package dfs;

import java.util.*;

public class Main6_1 {

    int answer;
    int[] num;
    boolean[] visited;

    public void dfs(int n, int sum, int level) {
        if(level == num.length) {
            if(sum > n && sum < answer) {
                answer = sum;
            }
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, sum * 10 + num[i], level + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int n){
        answer = Integer.MAX_VALUE;
        num = new int[0];
        int temp = n;

        while(temp != 0) {
            num = Arrays.copyOf(num, num.length + 1);
            num[num.length - 1] = temp % 10;
            temp /= 10;
        }
        visited = new boolean[num.length];
        dfs(n, 0, 0);
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args){
        Main6_1 T = new Main6_1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}

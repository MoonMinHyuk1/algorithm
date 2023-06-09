package dfs;

import java.util.*;

public class Main6_2 {

    int answer;
    boolean[][] ch;
    boolean[] visited;
    Deque<Integer> deque;

    public void dfs() {
        if(deque.size() == 7) {
            answer++;
            return;
        }
        for(int i = 0; i < 7; i++) {
            if(!visited[i]) {
                if((deque.isEmpty()) || (!deque.isEmpty() && !ch[deque.peekLast()][i])) {
                    visited[i] = true;
                    deque.offerLast(i);
                    dfs();
                    deque.pollLast();
                    visited[i] = false;
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        ch = new boolean[7][7];
        visited = new boolean[7];
        deque = new ArrayDeque<>();

        for(int i = 0; i < fight.length; i++) {
            ch[fight[i][0] - 1][fight[i][1] - 1] = true;
            ch[fight[i][1] - 1][fight[i][0] - 1] = true;
        }
        dfs();

        return answer;
    }

    public static void main(String[] args){
        Main6_2 T = new Main6_2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

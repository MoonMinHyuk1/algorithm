package bfs;

import java.util.*;

public class Main7_2 {

    public int bfs(int[] pool, int a, int b, int home) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int n: pool) {
            set.add(n);
        }
        queue.offer(new int[]{a, 0});
        while(!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int next = now[0] + a;
                if(next == home) {
                    return cnt;
                }
                if(0 < next && next <= 10000 && !set.contains(next)) {
                    queue.offer(new int[]{next, 0});
                }
                if(now[1] == 0) {
                    next = now[0] - b;
                    if(next == home) {
                        return cnt;
                    }
                    if(0 < next && next <= 10000 && !set.contains(next)) {
                        queue.offer(new int[]{next, 1});
                    }
                }
            }
        }

        return -1;
    }

    public int solution(int[] pool, int a, int b, int home){
        int answer = 0;

        answer = bfs(pool, a, b, home);

        return answer;
    }

    public static void main(String[] args){
        Main7_2 T = new Main7_2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}

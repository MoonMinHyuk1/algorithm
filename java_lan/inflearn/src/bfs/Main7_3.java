package bfs;

import java.util.*;

public class Main7_3 {

    public int bfs(int s, int e) {
        int cnt = 0, start = 0;
        boolean[][] visited = new boolean[2][200001];
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        queue.offer(s);
        visited[start % 2][s] = true;
        while(!queue.isEmpty()) {
            cnt++;
            e += ++start;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int now = queue.poll();
                list.push(now + 1);
                list.push(now - 1);
                list.push(now * 2);
                while(!list.isEmpty()) {
                    int next = list.pop();
                    if(next == e) {
                        return cnt;
                    }
                    if(0 <= next && next <= 200000 && !visited[start % 2][next]) {
                        visited[start % 2][next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }

    public int solution(int s, int e){
        int answer = 0;

        answer = bfs(s, e);

        return answer;
    }

    public static void main(String[] args){
        Main7_3 T = new Main7_3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}

package bfs;

import java.util.*;

public class Main7_1 {

    public int bfs(int[] nums) {
        int cnt = 0;
        boolean[] visited = new boolean[nums.length];
        Queue<Integer[]> queue = new LinkedList<>();

        queue.add(new Integer[]{0, nums[0]});
        visited[0] = true;
        while(!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer[] now = queue.poll();
                for(int j = 1; j <= now[1]; j++) {
                    int index = now[0] + j;
                    if(index < visited.length && !visited[index]) {
                        visited[index] = true;
                        if(index == visited.length - 1) {
                            return cnt;
                        }
                        queue.offer(new Integer[]{index, nums[index]});
                    }
                }
            }
        }

        return -1;
    }

    public int solution(int[] nums){
        int answer = 0;

        answer = bfs(nums);

        return answer;
    }

    public static void main(String[] args){
        Main7_1 T = new Main7_1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}

package data_structure;

import java.util.*;

public class Main3_5 {

    static class Task implements Comparable<Task> {

        int index, start, time;

        public Task(int index, int start, int time) {
            this.index = index;
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Task o) {
            if(this.time < o.time) {
                return -1;
            } else if(this.time > o.time) {
                return 1;
            } else {
                return this.index - o.index;
            }
        }
    }

    public int[] solution(int[][] tasks){
        int[] answer = new int[tasks.length];
        PriorityQueue<Task> pq = new PriorityQueue<>();
        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.start - o2.start == 0) {
                    return o1.time - o2.time;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        for(int i = 0; i < tasks.length; i++) {
            queue.offer(new Task(i, tasks[i][0], tasks[i][1]));
        }

        int index = 0, endTime = 0;
        while(!queue.isEmpty()) {
            if (pq.isEmpty()) {
                Task task = queue.poll();
                pq.offer(task);
            } else {
                Task end = pq.poll();
                answer[index++] = end.index;
                endTime = Math.max(endTime, end.start) + end.time;
                while(!queue.isEmpty() && (endTime >= queue.peek().start)) {
                    pq.offer(queue.poll());
                }
            }
        }
        while(!pq.isEmpty()) {
            answer[index++] = pq.poll().index;
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_5 T = new Main3_5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}

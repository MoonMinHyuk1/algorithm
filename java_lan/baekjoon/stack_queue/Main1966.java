package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main1966 {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            int num = arr[i];
            queue.offer(new int[]{i, num});
            pq.offer(num);
        }
        while(!queue.isEmpty()) {
            int priority = pq.peek();
            int[] now = queue.poll();
            if(now[1] == priority) {
                if(now[0] == m) {
                    answer++;
                    break;
                } else {
                    pq.poll();
                    answer++;
                }
            } else {
                queue.offer(now);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(solution(n, m, arr)).append("\n");
        }

        System.out.println(sb);
    }
}

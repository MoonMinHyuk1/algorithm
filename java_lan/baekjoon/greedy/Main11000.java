package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 1;
        pq.offer(arr[0][1]);
        for(int i = 1; i < arr.length; i++) {
            if(pq.isEmpty()) {
                pq.offer(arr[i][1]);
            } else if(arr[i][0] < pq.peek()) {
                pq.offer(arr[i][1]);
                answer = Math.max(answer, pq.size());
            } else {
                while(!pq.isEmpty() && arr[i][0] >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(arr[i][1]);
            }
        }

        System.out.println(answer);
    }
}

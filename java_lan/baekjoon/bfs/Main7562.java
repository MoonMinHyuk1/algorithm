package java_lan.baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Main7562 {

    public static int solution(int n, int[] s, int[] e) {
        int answer = 0;
        boolean[][] arr = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        arr[s[0]][s[1]] = true;
        pq.offer(new int[]{s[0], s[1], 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == e[0] && now[1] == e[1]) {
                answer = now[2];
                break;
            }
            for(int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && !arr[nx][ny]) {
                    arr[nx][ny] = true;
                    pq.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] s = new int[2];
            int[] e = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            s[0] = Integer.parseInt(st.nextToken());
            s[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            e[0] = Integer.parseInt(st.nextToken());
            e[1] = Integer.parseInt(st.nextToken());
            sb.append(solution(n, s, e)).append("\n");
        }
        System.out.println(sb);
    }
}

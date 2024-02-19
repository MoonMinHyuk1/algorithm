package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main16236 {

    static int shark;
    static int eat;

    public static int[] find(int[][] arr, int[] now) {
        int[] next = new int[3];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[arr.length][arr.length];
        Queue<int[]> queue = new LinkedList<>();

        int cnt = 0;
        List<int[]> list = new ArrayList<>();
        queue.offer(new int[]{now[0], now[1]});
        visited[now[0]][now[1]] = true;
        while(!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length && arr[nx][ny] <= shark && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if(arr[nx][ny] > 0 && arr[nx][ny] < shark) {
                            list.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if(!list.isEmpty()) {
                break;
            }
        }
        if(!list.isEmpty()) {
            Collections.sort(list, (o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
            next[0] = list.get(0)[0];
            next[1] = list.get(0)[1];
            next[2] = cnt;
            arr[next[0]][next[1]] = 0;
            eat++;
            if (eat == shark) {
                shark++;
                eat = 0;
            }
        }

        return next;
    }

    public static int solution(int[][] arr) {
        int answer = 0;
        int[] now = new int[3];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 9) {
                    arr[i][j] = 0;
                    now[0] = i;
                    now[1] = j;
                }
            }
        }
        shark = 2;
        eat = 0;
        while(true) {
            int[] next = find(arr, now);
            if(next[2] == 0) {
                break;
            }
            now[0] = next[0];
            now[1] = next[1];
            answer += next[2];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(arr));
    }
}

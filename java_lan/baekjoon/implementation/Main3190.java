package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main3190 {

    static class Info {
        int time;
        String direction;

        public Info(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static int solution(int[][] arr, Queue<Info> queue) {
        int answer = 0;
        int n = arr.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int index = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        arr[0][0] = 2;
        deque.offerFirst(new int[]{0, 0});
        while(true) {
            answer++;
            int[] head = deque.peekFirst();
            int nx = head[0] + dx[index];
            int ny = head[1] + dy[index];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] != 2) {
                if(arr[nx][ny] == 0) {
                    int[] tail = deque.pollLast();
                    arr[tail[0]][tail[1]] = 0;
                }
                arr[nx][ny] = 2;
                deque.offerFirst(new int[]{nx, ny});
            } else {
                break;
            }
            if(!queue.isEmpty() && queue.peek().time == answer) {
                String direction = queue.poll().direction;
                if(direction.equals("L")) {
                    index = (index == 0) ? 3 : (index - 1);
                } else if(direction.equals("D")) {
                    index = (index + 1) % 4;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            arr[row][col] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        Queue<Info> queue = new LinkedList<>();
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            queue.offer(new Info(time, direction));
        }

        System.out.println(solution(arr, queue));
    }
}

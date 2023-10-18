package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main12100 {

    static int answer;
    static int[] index;

    public static void move(int[][] arr, int direction) {
        if(direction == 0) {        //왼쪽
            for(int i = 0; i < arr.length; i++) {
                Queue<Integer> queue = new LinkedList<>();
                for(int j = 0; j < arr.length; j++) {
                    if(arr[i][j] == 0) continue;
                    queue.offer(arr[i][j]);
                    arr[i][j] = 0;
                }
                int j = 0;
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    if(!queue.isEmpty() && now == queue.peek()) {
                        arr[i][j++] = now + queue.poll();
                    } else {
                        arr[i][j++] = now;
                    }
                }
            }
        } else if(direction == 1) { //오른쪽
            for(int i = 0; i < arr.length; i++) {
                Queue<Integer> queue = new LinkedList<>();
                for(int j = arr.length - 1; j >= 0; j--) {
                    if(arr[i][j] == 0) continue;
                    queue.offer(arr[i][j]);
                    arr[i][j] = 0;
                }
                int j = arr.length - 1;
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    if(!queue.isEmpty() && now == queue.peek()) {
                        arr[i][j--] = now + queue.poll();
                    } else {
                        arr[i][j--] = now;
                    }
                }
            }
        } else if(direction == 2) { //위
            for(int i = 0; i < arr.length; i++) {
                Queue<Integer> queue = new LinkedList<>();
                for(int j = 0; j < arr.length; j++) {
                    if(arr[j][i] == 0) continue;
                    queue.offer(arr[j][i]);
                    arr[j][i] = 0;
                }
                int j = 0;
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    if(!queue.isEmpty() && now == queue.peek()) {
                        arr[j++][i] = now + queue.poll();
                    } else {
                        arr[j++][i] = now;
                    }
                }
            }
        } else if(direction == 3) { //아래
            for(int i = 0; i < arr.length; i++) {
                Queue<Integer> queue = new LinkedList<>();
                for(int j = arr.length - 1; j >= 0; j--) {
                    if(arr[j][i] == 0) continue;
                    queue.offer(arr[j][i]);
                    arr[j][i] = 0;
                }
                int j = arr.length - 1;
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    if(!queue.isEmpty() && now == queue.peek()) {
                        arr[j--][i] = now + queue.poll();
                    } else {
                        arr[j--][i] = now;
                    }
                }
            }
        }
    }

    public static int findMax(int[][] arr) {
        int max = 0;
        int[][] temp = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < index.length; i++) {
            move(temp, index[i]);
        }
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp.length; j++) {
                max = Math.max(max, temp[i][j]);
            }
        }

        return max;
    }

    public static void dfs(int level, int[][] arr) {
        if(level == 5) {
            answer = Math.max(answer, findMax(arr));
            return;
        }
        for(int i = 0; i < 4; i++) {
            index[level] = i;
            dfs(level + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(왼쪽, 오른쪽, 위, 아래) 중복순열
        answer = 0;
        index = new int[5];
        dfs(0, arr);

        System.out.println(answer);
    }
}

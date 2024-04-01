package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main14888 {

    static int[] answer;
    static int[] order;
    static boolean[] visited;

    public static int calculate(int[] arr, char[] symbol) {
        Deque<Integer> deque = new ArrayDeque<>();

//        deque.offer(arr[0]);
//        for(int i = 0; i < symbol.length; i++) {
//            int index = order[i];
//            if(symbol[index] == '*') {
//                deque.offerLast(deque.pollLast() * arr[i + 1]);
//            } else if(symbol[index] == '/') {
//                deque.offerLast(deque.pollLast() / arr[i + 1]);
//            } else {
//                deque.offerLast(arr[i + 1]);
//            }
//        }
//        for(int i = 0; i < symbol.length; i++) {
//            int index = order[i];
//            if(symbol[index] == '+') {
//                deque.offerFirst(deque.pollFirst() + deque.pollFirst());
//            } else if(symbol[index] == '-') {
//                deque.offerFirst(deque.pollFirst() - deque.pollFirst());
//            }
//        }
//        num = deque.poll();

        deque.offer(arr[0]);
        for(int i = 0; i < symbol.length; i++) {
            int num = deque.pollLast();
            int index = order[i];
            if(symbol[index] == '+') {
                deque.offerLast(num + arr[i + 1]);
            } else if(symbol[index] == '-') {
                deque.offerLast(num - arr[i + 1]);
            } else if(symbol[index] == '*') {
                deque.offerLast(num * arr[i + 1]);
            } else if(symbol[index] == '/') {
                deque.offerLast(num / arr[i + 1]);
            }
        }

        return deque.poll();
    }

    public static void dfs(int[] arr, char[] symbol, int level) {
        if(level == symbol.length) {
            int num = calculate(arr, symbol);
            answer[0] = Math.max(answer[0], num);
            answer[1] = Math.min(answer[1], num);
            return;
        }
        for(int i = 0; i < symbol.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[level] = i;
                dfs(arr, symbol, level + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] cnt = new int[4];
        char[]symbol = new char[n - 1];
        int s = 0;
        for(int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                for(int j = 0; j < cnt[i]; j++) {
                    symbol[s++] = '+';
                }
            } else if(i == 1) {
                for(int j = 0; j < cnt[i]; j++) {
                    symbol[s++] = '-';
                }
            } else if(i == 2) {
                for(int j = 0; j < cnt[i]; j++) {
                    symbol[s++] = '*';
                }
            } else {
                for(int j = 0; j < cnt[i]; j++) {
                    symbol[s++] = '/';
                }
            }
        }

        answer = new int[2];
        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;
        order = new int[symbol.length];
        visited = new boolean[symbol.length];
        dfs(arr, symbol, 0);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}

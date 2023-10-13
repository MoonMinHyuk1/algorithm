package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i < arr.length; i++) {
            if(list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                dp[i][0] = i;
                dp[i][1] = list.size() - 1;
            } else {
                int lt = 0, rt = list.size() - 1;
                while(lt <= rt) {
                    int mid = (lt + rt) / 2;
                    if(list.get(mid) < arr[i]) {
                        lt = mid + 1;
                    } else {
                        rt = mid - 1;
                    }
                }
                list.set(lt, arr[i]);
                dp[i][0] = i;
                dp[i][1] = lt;
            }
        }
        Arrays.sort(dp, (o1, o2) -> (o1[1] == o2[1]) ? (o2[0] - o1[0]) : (o2[1] - o1[1]));
        int[] answer = new int[list.size()];
        int index = answer.length - 1;
        answer[index--] = dp[0][0];
        for(int i = 0; i < dp.length; i++) {
            if(dp[i][1] == index && dp[i][0] < answer[index + 1]) {
                answer[index--] = dp[i][0];
            }
        }

        System.out.println(list.size());
        for(int i = 0; i < answer.length; i++) {
            System.out.print(arr[answer[i]] + " ");
        }
    }
}

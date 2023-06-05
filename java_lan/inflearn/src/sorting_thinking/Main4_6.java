package sorting_thinking;

import java.util.*;

public class Main4_6 {

    public int solution(int[] tasks, long k) {
        int answer = -1;
        int[] arr = new int[tasks.length + 1];

        for(int i = 0; i < tasks.length; i++) {
            arr[i + 1] = tasks[i];
        }
        Arrays.sort(arr);
        int rest = tasks.length;
        for(int i = 1; i < arr.length; i++) {
            long time = ((long) rest * (arr[i] - arr[i - 1]));
            if(k < time) {
                long index = k % rest;
                int cnt = 0;
                for(int j = 0; j < tasks.length; j++) {
                    if(tasks[j] >= arr[i]) {
                        if (cnt == index) {
                            return j + 1;
                        }
                        cnt++;
                    }
                }
            } else {
                k -= time;
                rest--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main4_6 T = new Main4_6();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

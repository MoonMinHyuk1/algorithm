package data_structure;

import java.util.*;

public class Main3_3 {

    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];
        Deque<Integer> in = new ArrayDeque<>();
        Deque<Integer> out = new ArrayDeque<>();
        int sec = arrival[0], index = 0, lastSec = Integer.MIN_VALUE;
        boolean lastOut = false;

        while(true) {
            for(int i = index; i < arrival.length; i++) {
                if(arrival[i] == sec) {
                    if(state[i] == 0) {
                        in.offer(i);
                    } else if(state[i] == 1) {
                        out.offer(i);
                    }
                } else {
                    index = i;
                    break;
                }
            }

            if(lastSec == sec - 1) {
                if(lastOut) {
                    if(!out.isEmpty()) {
                        answer[out.pollFirst()] = sec;
                        lastSec = sec;
                        lastOut = true;
                    } else if(!in.isEmpty()) {
                        answer[in.pollFirst()] = sec;
                        lastSec = sec;
                        lastOut = false;
                    }
                } else {
                    if(!in.isEmpty()) {
                        answer[in.pollFirst()] = sec;
                        lastSec = sec;
                        lastOut = false;
                    } else if(!out.isEmpty()) {
                        answer[out.pollFirst()] = sec;
                        lastSec = sec;
                        lastOut = true;
                    }
                }
            } else {
                if(!out.isEmpty()) {
                    answer[out.pollFirst()] = sec;
                    lastSec = sec;
                    lastOut = true;
                } else if(!in.isEmpty()) {
                    answer[in.pollFirst()] = sec;
                    lastSec = sec;
                    lastOut = false;
                }
            }

            if(sec >= arrival[arrival.length - 1] && in.isEmpty() && out.isEmpty()) {
                break;
            }
            sec++;
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_3 T = new Main3_3();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

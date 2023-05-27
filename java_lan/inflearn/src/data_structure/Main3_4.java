package data_structure;

import java.util.*;

public class Main3_4 {

    public int getStartTime(String str) {
        String time = str.split(" ")[0];

        int hour = Integer.valueOf(time.split(":")[0]);
        int minute = Integer.valueOf(time.split(":")[1]);

        return hour * 60 + minute;
    }

    public int getEndTime(String str, int[] laser) {
        String time = str.split(" ")[0];
        int num = Integer.valueOf(str.split(" ")[1]);

        int hour = Integer.valueOf(time.split(":")[0]);
        int minute = Integer.valueOf(time.split(":")[1]);

        return hour * 60 + minute + laser[num];
    }

    public int solution(int[] laser, String[] enter){
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int now = getStartTime("09:00");

        for(int i = 0; i < enter.length; i++) {
            deque.offer(i);
            int start = getStartTime(enter[i]);
            if(start >= now) {
                int index = deque.pollFirst();
                now = getEndTime(enter[index], laser);
            }
            answer = Math.max(answer, deque.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_4 T = new Main3_4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}

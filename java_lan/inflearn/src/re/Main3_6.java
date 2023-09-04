package re;

import java.util.*;

public class Main3_6 {

    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] cnt = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(i, 0);
        }
        for(int i = 0; i < meetings.length; i++) {
            meetings[i][1] -= meetings[i][0];
        }
        Arrays.sort(meetings, (o1, o2) -> (o1[0] - o2[0]));
        for(int i = 0; i < meetings.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<int[]> rooms = new PriorityQueue<>((o1, o2) -> ((o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1])));
            for(int key: map.keySet()) {
                if(map.get(key) <= meetings[i][0]) {
                    pq.offer(key);
                }
                rooms.offer(new int[]{key, map.get(key)});
            }
            if(!pq.isEmpty()) {
                int room = pq.poll();
                map.put(room, map.get(room) + meetings[i][1]);
                cnt[room]++;
            } else {
                int[] room = rooms.poll();
                map.put(room[0], map.get(room[0]) + meetings[i][1]);
                cnt[room[0]]++;
            }
            pq.clear();
            rooms.clear();
        }
        int max = Integer.MIN_VALUE;
        for(int num: cnt) {
            max = Math.max(max, num);
        }
        for(int i = 0; i < cnt.length; i++) {
            if(max == cnt[i]) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_6 T = new Main3_6();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}

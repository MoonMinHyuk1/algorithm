package data_structure;

import java.util.*;

public class Main3_6 {

    static class Room implements Comparable<Room> {

        int roomNum, endTime;

        public Room(int roomNum, int endTime) {
            this.roomNum = roomNum;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            return (this.endTime == o.endTime) ? (this.roomNum - o.roomNum) : (this.endTime - o.endTime);
        }
    }

    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] rooms = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<Room> pq = new PriorityQueue<>();

        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < n; i++) {
            set.add(i);
        }
        for(int i = 0; i < meetings.length; i++) {
            while(!pq.isEmpty() && pq.peek().endTime <= meetings[i][0]) {
                set.add(pq.poll().roomNum);
            }
            if(!set.isEmpty()) {
                int roomNum = set.pollFirst();
                rooms[roomNum]++;
                Room room = new Room(roomNum, meetings[i][1]);
                pq.offer(room);
            } else {
                Room exitRoom = pq.poll();
                rooms[exitRoom.roomNum]++;
                Room room = new Room(exitRoom.roomNum, exitRoom.endTime + (meetings[i][1] - meetings[i][0]));
                pq.offer(room);
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(rooms[i] > max) {
                max = rooms[i];
                answer = i;
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

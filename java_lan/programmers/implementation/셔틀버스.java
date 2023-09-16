import java.util.*;

class Solution {
    
    public int toInteger(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    
    public String toString(int time) {
        String hour = String.valueOf(time / 60);
        String minute = String.valueOf(time % 60);
        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() == 1) minute = "0" + minute;
        return hour + ":" + minute;
    }
    
    public boolean collect(PriorityQueue<int[]> pq, int n, int t, int m, int end) {
        int index = pq.size();
        PriorityQueue<int[]> time = new PriorityQueue<>((o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        
        time.offer(new int[]{end, index});
        for(int[] arr: pq) {
            time.offer(arr);
        }
        int now = toInteger("09:00");
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            while(!time.isEmpty() && cnt < m) {
                if(time.peek()[0] <= now) {
                    int[] arr = time.poll();
                    cnt++;
                    if(arr[1] == index) return true;
                } else {
                    break;
                }
            }
            now += t;
        }
        
        return false;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        
        for(int i = 0; i < timetable.length; i++) {
            pq.offer(new int[]{toInteger(timetable[i]), i});
        }
        int end = toInteger("09:00") + t * (n - 1);
        for(int i = end; i >= 0; i--) {
            if(collect(pq, n, t, m, i)) {
                return toString(i);
            }
        }
        
        return answer;
    }
}
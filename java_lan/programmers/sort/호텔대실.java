import java.util.*;

class Solution {
    
    static class Time implements Comparable<Time> {
        int start, end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Time o) {
            return (this.end == o.end) ? (this.start - o.start) : (this.end - o.end);
        }
    }
    
    public int makeTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        
        return (hour * 60) + minute;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> list = new ArrayList<>();
        List<Time> room = new ArrayList<>();
        
        for(int i = 0; i < book_time.length; i++) {
            list.add(new Time(makeTime(book_time[i][0]), makeTime(book_time[i][1]) + 10));
        }
        Collections.sort(list);
        for(Time time: list) {
            boolean flag = true;
            int index = 0;
            for(int i = 0; i < room.size(); i++) {
                if(room.get(i).end <= time.start) {
                    index = i;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                room.add(time);
            } else {
                room.remove(index);
                room.add(time);
            }
            Collections.sort(room, new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    return o2.end - o1.end;
                }
            });
        }
        answer = room.size();
        
        return answer;
    }
}
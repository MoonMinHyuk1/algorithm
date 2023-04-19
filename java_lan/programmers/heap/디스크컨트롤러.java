import java.util.*;

class Solution {
    static class Disk implements Comparable<Disk> {
        int start, time;
        
        public Disk(int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Disk disk) {
            if(this.time < disk.time) {
                return -1;
            } else if(this.time > disk.time) {
                return 1;
            } else {
                if(this.start > disk.start) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0, start = 0;
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        
        for(int i = 0; i < jobs.length; i++) {
            pq.offer(new Disk(jobs[i][0], jobs[i][1]));
        }
        List<Disk> disks = new ArrayList<>();
        while(!pq.isEmpty()) {
            Disk now = pq.poll();
            if(now.start > start) {
                disks.add(now);
            } else {
                answer += (now.time + start - now.start);
                start += now.time;
                while(!disks.isEmpty()) {
                    pq.offer(disks.remove(0));
                }
            }
            if(pq.isEmpty() && !disks.isEmpty()) {
                int minStart = Integer.MAX_VALUE;
                while(!disks.isEmpty()) {
                    Disk disk = disks.remove(0);
                    minStart = Math.min(minStart, disk.start);
                    pq.offer(disk);
                }
                start = minStart;
            }
        }
        answer /= jobs.length;
        
        return answer;
    }
}
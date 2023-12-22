import java.util.*;

class Solution {
    
    int[] index;
    
    public void intersection(int[][] line, List<long[]> list) {
        int[] l1 = line[index[0]];
        int[] l2 = line[index[1]];
        long a = (long) l1[0], b = (long) l1[1], c = (long) l2[0], 
             d = (long) l2[1], e = (long) l1[2], f = (long) l2[2];
        
        if(a * d - b * c == 0) return;
        long x = (b * f - e * d) / (a * d - b * c);
        long y = (e * c - a * f) / (a * d - b * c);
        double cx = (double) (b * f - e * d) / (a * d - b * c);
        double cy = (double) (e * c - a * f) / (a * d - b * c);
        if(cx - x != 0 || cy - y != 0) return;
        list.add(new long[]{x, y});
    }
    
    public void combi(int level, int s, int[][] line, List<long[]> list) {
        if(level == 2) {
            intersection(line, list);
            return;
        }
        for(int i = s; i < line.length; i++) {
            index[level] = i;
            combi(level + 1, i + 1, line, list);
        }
    }
    
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> list = new ArrayList<>();
        index = new int[2];
        
        combi(0, 0, line, list);
        long minx = Long.MAX_VALUE, miny = Long.MAX_VALUE;
        long maxx = Long.MIN_VALUE, maxy = Long.MIN_VALUE;
        for(long[] arr: list) {
            minx = Math.min(minx, arr[0]);
            miny = Math.min(miny, arr[1]);
            maxx = Math.max(maxx, arr[0]);
            maxy = Math.max(maxy, arr[1]);
        }
        int n = (int) (maxy - miny) + 1;
        answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxx - minx + 1; i++) {
            sb.append(".");
        }
        for(int i = 0; i < answer.length; i++) {
            answer[i] = sb.toString();
        }
        for(long[] arr: list) {
            int y = (int) (maxy - arr[1]);
            int x = (int) ((maxx - minx) - (maxx - arr[0]));
            char[] carr = answer[y].toCharArray();
            carr[x] = '*';
            answer[y] = String.valueOf(carr);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        Map<String, Integer> map = new HashMap<>();
        
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        final int s = map.get(sort_by);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[s] - o2[s]));
        int index = map.get(ext);
        for(int i = 0; i < data.length; i++) {
            if(data[i][index] < val_ext) {
                pq.offer(data[i]);
            }
        }
        answer = new int[pq.size()][4];
        index = 0;
        while(!pq.isEmpty()) {
            answer[index++] = pq.poll();
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        Queue<int[]> queue = new LinkedList<>();
        
        for(String str: cities) {
            str = str.toUpperCase();
            map.putIfAbsent(str, map.size());
        }
        for(int i = 0; i < cities.length; i++) {
            int n = map.get(cities[i].toUpperCase());
            boolean flag = false;
            for(int[] arr: pq) {
                if(arr[0] == n) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                answer += 1;
                while(!pq.isEmpty()) {
                    int[] arr = pq.poll();
                    if(arr[0] == n) {
                        pq.offer(new int[]{n, i});
                        break;
                    }
                    queue.offer(arr);
                }
                while(!queue.isEmpty()) {
                    pq.offer(queue.poll());
                }
            } else {
                answer += 5;
                if(pq.size() < cacheSize) {
                    pq.offer(new int[]{n, i});
                } else if(!pq.isEmpty()) {
                    pq.poll();
                    pq.offer(new int[]{n, i});
                }
            }
        }
        
        return answer;
    }
}
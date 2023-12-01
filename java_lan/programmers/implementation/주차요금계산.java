import java.util.*;

class Solution {
    
    public int change(String str) {
        String[] arr = str.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        
        for(String str: records) {
            String[] arr = str.split(" ");
            int time = change(arr[0]);
            int number = Integer.valueOf(arr[1]);
            if(arr[2].equals("IN")) {
                in.put(number, time);
            } else if(arr[2].equals("OUT")) {
                int start = in.get(number);
                map.put(number, map.getOrDefault(number, 0) + (time - start));
                in.remove(number);
            }
        }
        int end = change("23:59");
        for(int key: in.keySet()) {
            int start = in.get(key);
            map.put(key, map.getOrDefault(key, 0) + (end - start));
        }
        for(int key: map.keySet()) {
            int time = map.get(key) - fees[0];
            int money = fees[1];
            if(time > 0) {
                if(time % fees[2] > 0) {
                    time += fees[2];
                }
                time /= fees[2];
                money += (time * fees[3]);
            }
            pq.offer(new int[]{key, money});
        }
        answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            answer[index++] = arr[1];
        }
        
        return answer;
    }
}
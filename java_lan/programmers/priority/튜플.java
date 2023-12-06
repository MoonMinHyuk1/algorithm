import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> (o1.size() - o2.size()));
        
        s = s.substring(1, s.length() - 1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{') {
                int j = i + 1;
                for(; j < s.length(); j++) {
                    if(s.charAt(j) == '}') {
                        break;
                    }
                }
                String str = s.substring(i + 1, j);
                String[] arr = str.split(",");
                List<Integer> l = new ArrayList<>();
                for(String num: arr) {
                    l.add(Integer.valueOf(num));
                }
                pq.offer(l);
                i = j + 1;
            }
        }
        while(!pq.isEmpty()) {
            List<Integer> l = pq.poll();
            for(int num: l) {
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
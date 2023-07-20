import java.util.*;
import java.util.stream.*;

class Solution {
    
    static class Info implements Comparable<Info> {
        String name;
        int cnt, n;
        
        public Info(String name, int cnt, int n) {
            this.name = name;
            this.cnt = cnt;
            this.n = n;
        }
        
        @Override
        public int compareTo(Info o) {
            return (this.n == o.n) ? (o.cnt - this.cnt) : (this.n - o.n);
        }
    }
    
    PriorityQueue<Info> pq;
    Map<Integer, Set<Character>> map;
    Character[] ch = new Character[26];
    
    public void combination(int n, int level, String str, int index) {
        if(n == level) {
            int cnt = 0;
            for(Set<Character> set: map.values()) {
                boolean flag = true;
                for(char c: str.toCharArray()) {
                    if(!set.contains(c)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            if(cnt >= 2) pq.offer(new Info(str, cnt, n));
            return;
        }
        for(int i = index; i < ch.length; i++) {
            combination(n, level + 1, str + ch[i], i + 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        pq = new PriorityQueue<>();
        map = new HashMap<>();
        
        for(int i = 0; i < ch.length; i++) {
            ch[i] = (char) ('A' + i);
        }
        for(int i = 0; i < orders.length; i++) {
            String order = orders[i];
            map.put(i, new HashSet<>());
            for(char c: order.toCharArray()) {
                map.get(i).add(c);
            }
        }
        for(int i = 0; i < course.length; i++) {
            int n = course[i];
            combination(n, 0, "", 0);
        }
        int n = pq.peek().n;
        int max = pq.peek().cnt;
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(info.n == n) {
                if(max == info.cnt) {
                    list.add(info.name);
                }
            } else {
                list.add(info.name);
                max = info.cnt;
                n = info.n;
            }
        }
        Collections.sort(list);
        answer = list.toArray(String[]::new);
        
        return answer;
    }
}
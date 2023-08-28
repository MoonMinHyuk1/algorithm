import java.util.*;

class Solution {
    
    int[] index;
    PriorityQueue<int[]> pq;
    
    public void salesum(int level, List<Integer> sales, int sum, List<Integer> list) {
        if(level == sales.size()) {
            list.add(sum);
            return;
        }
        salesum(level + 1, sales, sum, list);
        salesum(level + 1, sales, sum + sales.get(level), list);
    }
    
    public void service(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        int[] sales = new int[emoticons.length];

        for(int i = 0; i < emoticons.length; i++) {
            sales[i] = emoticons[i] - (emoticons[i] * index[i] / 100);
        }
        for(int i = 0; i < users.length; i++) {
            int sum = 0;
            List<Integer> s = new ArrayList<>();
            for(int j = 0; j < sales.length; j++) {
                if(index[j] >= users[i][0]) {
                    sum += sales[j];
                    s.add(sales[j]);
                }
            }
            if(sum >= users[i][1]) {
                result[0]++;
            } else {
                List<Integer> list = new ArrayList<>();
                salesum(0, s, 0, list);
                Collections.sort(list, Collections.reverseOrder());
                for(int n: list) {
                    if(n < users[i][1]) {
                        result[1] += n;
                        break;
                    }
                }
            }
        }
        
        pq.offer(result);
    }
    
    public void dfs(int[][] users, int[] emoticons, int level) {
        if(level == emoticons.length) {
            service(users, emoticons);
            return;
        }
        for(int i = 0; i < 4; i++) {
            index[level] = (i + 1) * 10;
            dfs(users, emoticons, level + 1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        index = new int[emoticons.length];
        pq = new PriorityQueue<>((o1, o2) -> ((o1[0] == o2[0]) ? (o2[1] - o1[1]) : (o2[0] - o1[0])));
        
        dfs(users, emoticons, 0);
        answer = pq.poll();
        
        return answer;
    }
}
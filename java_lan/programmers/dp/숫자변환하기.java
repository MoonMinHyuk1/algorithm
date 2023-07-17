import java.util.*;

class Solution {
    
    public int bfs(int x, int y, int n) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.offer(x);
        set.add(x);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now > y) continue;
                if(now == y) {
                    return cnt;
                }
                if(!set.contains(now + n)) {
                    queue.offer(now + n);
                    set.add(now + n);
                }
                if(!set.contains(now * 2)) {
                    queue.offer(now * 2);
                    set.add(now * 2);
                }
                if(!set.contains(now * 3)) {
                    queue.offer(now * 3);
                    set.add(now * 3);
                }
            }
            cnt++;
        }
        
        return -1;
    }
    
    public int dynamic(int x, int y, int n) {
        int[] dp = new int[y + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for(int i = x + 1; i < dp.length; i++) {
            if(i - n >= x && dp[i - n] < Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
            if(i % 2 == 0 && i / 2 >= x && dp[i / 2] < Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0 && i / 3 >= x && dp[i / 3] < Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        return (dp[y] == Integer.MAX_VALUE) ? -1 : dp[y];
    }
    
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        // int answer = dynamic(x, y, n);
        
        return answer;
    }
}
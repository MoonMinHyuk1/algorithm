import java.util.*;

class Solution {
    
    int score;
    int[] arr, answer;
    PriorityQueue<int[]> pq;
    
    public void win(int[] info) {
        int lion = 0, apeach = 0;
        for(int i = 0; i < info.length; i++) {
            if(arr[i] == 0 && info[i] == 0) continue;
            if(arr[i] > info[i]) lion += (10 - i);
            else apeach += (10 - i);
        }
        if(lion > apeach && score <= lion - apeach) {
            score = lion - apeach;
            int[] a = new int[12];
            for(int i = 0; i < arr.length; i++) {
                a[i] = arr[i];
            }
            a[a.length - 1] = score;
            pq.offer(a);
        }
    }
    
    public void dfs(int level, int n, int[] info) {
        if(level == info.length) {
            if(n == 0) {
                win(info);
            }
            return;
        }
        for(int i = n; i >= 0; i--) {
            arr[level] = i;
            dfs(level + 1, n - i, info);
        }
    }
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        arr = new int[11];
        score = 0;
        pq = new PriorityQueue<>((o1, o2) -> (o2[11] - o1[11]));
        
        dfs(0, n, info);
        if(pq.isEmpty()) return new int[]{-1};
        while(!pq.isEmpty() && pq.peek()[11] == score) {
            int[] now = pq.poll();
            for(int i = 10; i >= 0; i--) {
                if(now[i] == answer[i]) continue;
                if(now[i] > answer[i]) {
                    for(int j = 0; j < answer.length; j++) {
                        answer[j] = now[j];
                    }
                }
                break;
            }
        }
        
        return answer;
    }
}
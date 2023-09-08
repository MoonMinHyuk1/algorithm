import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Set<Integer>> win = new ArrayList<>();
        List<Set<Integer>> lose = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        
        for(int i = 0; i <= n; i++) {
            win.add(new HashSet<>());
            lose.add(new HashSet<>());
        }
        for(int i = 0; i < results.length; i++) {
            win.get(results[i][0]).add(results[i][1]);
            lose.get(results[i][1]).add(results[i][0]);
        }
        for(int j = 1; j <= n; j++) {
            for(int k = 1; k <= n; k++) {
                for(int l = 1; l <= n; l++) {
                    if(win.get(j).contains(l) && win.get(l).contains(k)) {
                        win.get(j).add(k);
                        lose.get(k).add(j);
                    }
                    if(lose.get(j).contains(l) && lose.get(l).contains(k)) {
                        lose.get(j).add(k);
                        win.get(k).add(j);
                    }
                }
            }
        }
        for(int j = 1; j <= n; j++) {
            if(win.get(j).size() + lose.get(j).size() == n - 1 && !visited[j]) {
                visited[j] = true;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i]) answer++;
        }
        
        return answer;
    }
}
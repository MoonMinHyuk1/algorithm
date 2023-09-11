class Solution {
    
    int answer;
    int[] queen;
    
    public boolean check(int x, int y) {
        for(int i = 0; i < x; i++) {
            if(queen[i] == y) return false;
            if(i - x == queen[i] - y) return false;
            if(x - i == y - queen[i]) return false;
            if(i - x == y - queen[i]) return false;
            if(x - i == queen[i] - y) return false;
        }
        return true;
    }
    
    public void dfs(int level, int n) {
        if(level == n) {
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(check(level, i)) {
                queen[level] = i;
                dfs(level + 1, n);
                queen[level] = 0;
            }
        }
    }
    
    public int solution(int n) {
        answer = 0;
        queen = new int[n];
        
        dfs(0, n);
        
        return answer;
    }
}
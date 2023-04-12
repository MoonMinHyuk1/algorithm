class Solution {
    boolean[] visited;
    int answer;
    
    public void dfs(int level, int sum, int k, int[][] dungeons) {
        if (level > dungeons.length) {
            return;
        }
        if(sum > answer) {
            answer = sum;
        }
        for(int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k - dungeons[i][0] >= 0) {
                visited[i] = true;
                dfs(level + 1, sum + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        dfs(0, 0, k, dungeons);
        
        return answer;
    }
}
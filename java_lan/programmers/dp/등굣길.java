class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            if(x == 0) {
                for(int j = y; j < n; j++) {
                    dp[j][0] = 0;
                }
            }
            if(y == 0) {
                for(int j = x; j < m; j++) {
                    dp[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                boolean puddle = false;
                for(int k = 0; k < puddles.length; k++) {
                    if(i == puddles[k][1] - 1 && j == puddles[k][0] - 1) {
                        puddle = true;
                        break;
                    }
                }
                if(!puddle) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
        answer = dp[n - 1][m - 1];
        
        return answer;
    }
}
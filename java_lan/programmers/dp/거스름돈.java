class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] dp = new int[money.length + 1][n + 1];
        
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - money[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - money[i - 1]];
                }
            }
        }
        answer = dp[money.length][n];
        
        return answer;
    }
}
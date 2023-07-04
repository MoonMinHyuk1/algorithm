class Solution {
    
    String answer;
    
    public void dfs(int n) {
        if(n == 1) answer += "1";
        else if(n == 2) answer += "2";
        else if(n == 3 || n == 0) answer += "4";
        else {
            dfs((n - 1) / 3);
            dfs(n % 3);
        }
    }
    
    public String solution(int n) {
        answer = "";
        
        dfs(n);
        
        return answer;
    }
}
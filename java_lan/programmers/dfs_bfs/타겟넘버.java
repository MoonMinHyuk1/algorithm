class Solution {
    int answer = 0;
    
    public void dfs(int level, int sum, int target, int[] numbers) {
        if(level == numbers.length) {
            answer = (sum == target) ? (answer + 1) : answer;
            return;
        }
        dfs(level + 1, sum + numbers[level], target, numbers);
        dfs(level + 1, sum - numbers[level], target, numbers);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        
        return answer;
    }
}
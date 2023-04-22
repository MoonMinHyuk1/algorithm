class Solution {
    int answer, result;
    String[] words = {"A", "E", "I", "O", "U"};
    
    public void dfs(String word, String made, int level) {
        if(word.equals(made)) {
            answer = result;
            return;
        }
        if(answer != 0) {
            return;
        }
        if(level == 5) {
            return;
        }
        for(int i = 0; i < words.length; i++) {
            result++;
            dfs(word, made + words[i], level + 1);
        }
    }
    
    public int solution(String word) {
        answer = 0;
        dfs(word, "", 0);
        
        return answer;
    }
}
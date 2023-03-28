import java.util.*;

class Solution {
    static boolean[] visited;
    
    public boolean check(String str1, String str2) {
        int cnt = 0;
        
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        
        if(cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public int bfs(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(begin);
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String now = queue.poll();
                for(int j = 0; j < words.length; j++) {
                    if(!visited[j]) {
                        if(check(now, words[j])) {
                            if(words[j].equals(target)) {
                                return level;
                            }
                            visited[j] = true;
                            queue.offer(words[j]);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        
        return answer;
    }
}
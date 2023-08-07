import java.util.*;

class Solution {
    
    Set<List<String>> set;
    List<String> list;
    boolean[] visited;
    
    public boolean collect(String user, String ban) {
        if(user.length() != ban.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
    
    public void dfs(int index, String[] banned, String[] user) {
        if(index == banned.length) {
            Collections.sort(list);
            set.add(list);
            return;
        }
        
        for(int i = 0; i < user.length; i++) {
            if(visited[i]) continue;
            if(collect(user[i], banned[index])) {
                visited[i] = true;
                list.add(user[i]);
                dfs(index + 1, banned, user);
                visited[i] = false;
                list.remove(user[i]);
            }
        }
    }
    
    public int solution(String[] user, String[] banned) {
        int answer = 0;
        set = new HashSet<>();
        list = new ArrayList<>();
        visited = new boolean[user.length];
        
        dfs(0, banned, user);
        answer = set.size();
        
        return answer;
    }
}
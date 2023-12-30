import java.util.*;

class Solution {
    
    int answer;
    char[] arr= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] word;
    Map<String, Set<Integer>> map;
    boolean[] visited;
    
    public void dfs(int level) {
        if(level == arr.length) {
            answer++;
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            char c1 = arr[i];
            boolean flag = true;
            for(int j = 0; j < level; j++) {
                char c2 = word[j];
                String s1 = String.valueOf(c1) + String.valueOf(c2);
                String s2 = String.valueOf(c2) + String.valueOf(c1);
                int len = level - j - 1;
                if(map.get(s1) != null && !map.get(s1).contains(len)) {
                    flag = false;
                    break;
                }
                if(map.get(s2) != null && !map.get(s2).contains(len)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                word[level] = c1;
                visited[i] = true;
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int n, String[] data) {
        answer = 0;
        word = new char[arr.length];
        map = new HashMap<>();
        visited = new boolean[arr.length];
        
        for(String str: data) {
            String s = String.valueOf(str.charAt(0)) + String.valueOf(str.charAt(2));
            map.putIfAbsent(s, new HashSet<>());
            Set<Integer> set = map.get(s);
            if(set.isEmpty()) {
                if(str.charAt(3) == '=') {
                    set.add(str.charAt(4) - '0');
                } else if(str.charAt(3) == '<') {
                    int num = str.charAt(4) - '0';
                    if(num == 0) return 0;
                    for(int i = 0; i < num; i++) {
                        set.add(i);
                    }
                } else if(str.charAt(3) == '>') {
                    int num = str.charAt(4) - '0';
                    if(num == 6) return 0;
                    for(int i = num + 1; i <= 6; i++) {
                        set.add(i);
                    }
                }
            } else {
                Set<Integer> temp = new HashSet<>();
                if(str.charAt(3) == '=') {
                    temp.add(str.charAt(4) - '0');
                } else if(str.charAt(3) == '<') {
                    int num = str.charAt(4) - '0';
                    if(num == 0) return 0;
                    for(int i = 0; i < num; i++) {
                        temp.add(i);
                    }
                } else if(str.charAt(3) == '>') {
                    int num = str.charAt(4) - '0';
                    if(num == 6) return 0;
                    for(int i = num + 1; i <= 6; i++) {
                        temp.add(i);
                    }
                }
                List<Integer> list = new ArrayList<>();
                for(int num: set) {
                    if(temp.contains(num)) {
                        list.add(num);
                    }
                }
                set.clear();
                for(int num: list) {
                    set.add(num);
                }
                if(set.isEmpty()) return 0;
            }
        }
        dfs(0);
        
        return answer;
    }
}
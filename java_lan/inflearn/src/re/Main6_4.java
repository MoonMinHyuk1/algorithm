package re;

import java.util.*;

public class Main6_4 {

    Map<Character, Integer> map;
    Set<String> set;
    List<Character> list;
    boolean[] visited;

    public void dfs(int level, Stack<Character> stack) {
        if(level == list.size()) {
            String str = "";
            for(char c: stack) {
                str += c;
            }
            set.add(str);
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                stack.push(list.get(i));
                dfs(level + 1, stack);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    public String[] solution(String s){
        String[] answer = {};
        map = new HashMap<>();
        set = new HashSet<>();
        list = new ArrayList<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        char c = ' ';
        for(char key: map.keySet()) {
            if(map.get(key) % 2 == 1) {
                cnt++;
                c = key;
            } else {
                int n = map.get(key) / 2;
                while(n > 0) {
                    n--;
                    list.add(key);
                }
            }
        }
        if(cnt > 1) return answer;
        visited = new boolean[list.size()];
        dfs(0, new Stack<>());
        answer = new String[set.size()];
        int index = 0;
        for(String str: set) {
            String reverse = "";
            for(int i = str.length() - 1; i >= 0; i--) {
                reverse += str.charAt(i);
            }
            answer[index++] = (cnt == 0) ? (str + reverse) : (str + c + reverse);
        }

        return answer;
    }

    public static void main(String[] args){
        Main6_4 T = new Main6_4();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}

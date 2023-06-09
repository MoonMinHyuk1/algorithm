package dfs;

import java.util.*;

public class Main6_4 {

    Map<Character, Integer> map;
    List<Character> odd;
    char center;
    char[] arr;
    boolean[] visited;
    Set<String> set;
    Deque<Character> deque;

    public void dfs(int level) {
        if(level == arr.length) {
            String str = "";
            for(char c: deque) {
                str += c;
            }
            String reverse = new StringBuffer(str).reverse().toString();
            if(odd.size() > 0) {
                str += center;
            }
            str += reverse;
            set.add(str);
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                deque.offer(arr[i]);
                dfs(level + 1);
                deque.pollLast();
                visited[i] = false;
            }
        }
    }

    public String[] solution(String s){
        String[] answer = {};
        map = new HashMap<>();
        odd = new ArrayList<>();
        set = new HashSet<>();
        deque = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char key: map.keySet()) {
            if(map.get(key) % 2 == 1) {
                odd.add(key);
                center = key;
            }
            map.put(key, map.get(key) / 2);
        }
        if(map.get(center) != null && map.get(center) == 0) {
            map.remove(center);
        }
        if(odd.size() > 1) {
            return answer;
        }

        int size = 0, index = 0;
        for(int value: map.values()) {
            size += value;
        }
        arr = new char[size];
        visited = new boolean[size];
        for(char key: map.keySet()) {
            for(int i = 0; i < map.get(key); i++) {
                arr[index++] = key;
            }
        }

        dfs(0);
        answer = new String[set.size()];
        index = 0;
        for(String str: set) {
            answer[index++] = str;
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

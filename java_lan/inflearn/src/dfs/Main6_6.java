package dfs;

import java.util.*;

public class Main6_6 {

    Set<String> set;

    public void dfs(int index, String s, String str) {
        if(index == s.length()) {
            set.add(str);
            return;
        }
        String num = "";
        for(int i = 0; i < 2; i++) {
            if(index + i >= s.length()) {
                break;
            }
            num += s.charAt(index + i);
            if(i == 0 && Integer.parseInt(num) == 0) {
                break;
            }
            if(1 <= Integer.parseInt(num) && Integer.parseInt(num) <= 26) {
                dfs(index + i + 1, s, str + ('A' + Integer.parseInt(num) - 1));
            }
        }
    }

    public int solution(String s){
        int answer = 0;
        set = new HashSet<>();

        dfs(0, s, "");
        answer = set.size();

        return answer;
    }

    public static void main(String[] args){
        Main6_6 T = new Main6_6();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}

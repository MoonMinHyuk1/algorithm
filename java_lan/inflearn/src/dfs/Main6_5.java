package dfs;

import java.util.*;

public class Main6_5 {

    List<String> list;

    public void dfs(int level, int index, String s, String str) {
        if(level == 4) {
            if(index == s.length()) {
                list.add(str.substring(0, str.length() - 1));
            }
            return;
        }
        String num = "";
        for(int i = 0; i < 3; i++) {
            if(index + i >= s.length()) {
                break;
            }
            num += s.charAt(index + i);
            if(0 <= Integer.parseInt(num) && Integer.parseInt(num) <= 255) {
                dfs(level + 1, index + i + 1, s, str + num + ".");
            }
            if(i == 0 && Integer.parseInt(num) == 0) {
                break;
            }
        }
    }

    public String[] solution(String s){
        String[] answer = {};
        list = new ArrayList<>();

        dfs(0, 0, s, "");
        answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Main6_5 T = new Main6_5();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}

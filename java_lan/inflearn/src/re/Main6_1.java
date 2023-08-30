package re;

import java.util.*;

public class Main6_1 {

    int answer;
    List<Integer> list;
    boolean[] visited;

    public void dfs(int n, int level, int sum) {
        if(answer != -1) return;
        if(level == list.size()) {
            if(sum > n) {
                answer = sum;
            }
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, level + 1, sum * 10 + list.get(i));
                visited[i] = false;
            }
        }
    }

    public int solution(int n){
        answer = -1;
        list = new ArrayList<>();

        int tmp = n;
        while(tmp != 0) {
            list.add(tmp % 10);
            tmp /= 10;
        }
        Collections.sort(list);
        visited = new boolean[list.size()];
        dfs(n, 0, 0);

        return answer;
    }

    public static void main(String[] args){
        Main6_1 T = new Main6_1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}

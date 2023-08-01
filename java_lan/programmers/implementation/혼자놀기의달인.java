import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            if(visited[i]) continue;
            int index = i, cnt = 0;
            while(!visited[index]) {
                visited[index] = true;
                cnt++;
                index = cards[index] - 1;
            }
            list.add(cnt);
        }
        Collections.sort(list, Collections.reverseOrder());
        if(list.size() >= 2) {
            answer = list.get(0) * list.get(1);
        }
        
        return answer;
    }
}
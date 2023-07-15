import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> ((o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])));
        
        for(int i = 0; i < targets.length; i++) {
            answer++;
            int s = targets[i][0];
            int e = targets[i][1];
            int cnt = 1;
            while((i + cnt) < targets.length) {
                s = Math.max(s, targets[i + cnt][0]);
                e = Math.min(e, targets[i + cnt][1]);
                if(s < e) {
                    cnt++;
                } else {
                    break;
                }
            }
            i += (cnt - 1);
        }
        
        return answer;
    }
}
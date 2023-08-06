import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
//         int answer = 0;
//         boolean[] visited = new boolean[n];
        
//         for(int i = 0; i < stations.length; i++) {
//             for(int j = stations[i] - 1 - w; j <= stations[i] - 1 + w; j++) {
//                 if(j >= 0 && j < visited.length) {
//                     visited[j] = true;
//                 }
//             }
//         }
//         for(int i = 0; i < visited.length; i++) {
//             if(visited[i]) continue;
//             answer++;
//             i += (w * 2);
//         }
        int answer = 0;
        
        int index = 0, range = (w * 2) + 1;
        for(int i = 0; i < stations.length; i++) {
            int cnt = stations[i] - 1 - w - index;
            index = stations[i] + w;
            
            answer += (cnt / range);
            if(cnt % range > 0) {
                answer++;
            }
        }
        int cnt = n - index;
        if(cnt > 0) {
            answer += (cnt / range);
            if(cnt % range > 0) {
                answer++;
            }
        }

        return answer;
    }
}
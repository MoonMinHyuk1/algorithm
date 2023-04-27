import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = routes.length;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < routes.length - 1; i++) {
            int cnt = 0;
            for(int j = i + 1; j < routes.length; j++) {
                if(routes[j][0] <= routes[i][1] && routes[i][1] <= routes[j][1]) {
                    cnt++;
                } else {
                    break;
                }
            }
            answer -= cnt;
            i += cnt;
        }
        
        return answer;
    }
}
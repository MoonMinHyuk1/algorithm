import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        int x = 5, y = 5;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(char c: dirs.toCharArray()) {
            int index = 0;
            if(c == 'U') {
                index = 0;
            } else if(c == 'D') {
                index = 1;
            } else if(c == 'R') {
                index = 2;
            } else if(c == 'L') {
                index = 3;
            }
            int nx = x + dx[index];
            int ny = y + dy[index];
            if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;
            String str1 = x + "-" + y + "-" + nx + "-" + ny;
            String str2 = nx + "-" + ny + "-" + x + "-" + y;
            if(!set.contains(str1) && !set.contains(str2)) {
                set.add(str1);
                answer++;
            }
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}
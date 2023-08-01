import java.util.*;

class Solution {
    
    public int bfs(int[] s, int[] e, int[][] g) {
        int cnt = 0;
        boolean[][] visited = new boolean[g.length][g[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        queue.offer(new int[]{s[0], s[1]});
        visited[s[0]][s[1]] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0] == e[0] && now[1] == e[1]) {
                    return cnt;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(0 <= nx && nx < g.length && 0 <= ny && ny < g[0].length && !visited[nx][ny] && g[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int[] s = new int[2];
        int[] e = new int[2];
        int[] l = new int[2];
        int[][] g = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if(c == 'X') g[i][j] = 1;
                if(c == 'S') {
                    s[0] = i;
                    s[1] = j;
                }
                if(c == 'E') {
                    e[0] = i;
                    e[1] = j;
                }
                if(c == 'L') {
                    l[0] = i;
                    l[1] = j;
                }
            }
        }
        
        int result = bfs(s, l, g);
        if(result == -1) return -1;
        answer += result;
        result = bfs(l, e, g);
        if(result == -1) return -1;
        answer += result;
        
        return answer;
    }
}
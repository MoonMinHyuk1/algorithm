import java.util.*;

class Solution {
    
    boolean[][] visited;
    Map<Integer, List<Integer>> map;
    
    public void bfs(int[][] land, int i, int j) {
        int sum = 1;
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        set.add(j);
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if(nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && !visited[nx][ny] && land[nx][ny] == 1) {
                    sum++;
                    set.add(ny);
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        for(int n: set) {
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(sum);
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        map = new HashMap<>();
        visited = new boolean[land.length][land[0].length];
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, i, j);
                }
            }
        }
        for(List<Integer> list: map.values()) {
            int sum = 0;
            for(int n: list) {
                sum += n;
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
}
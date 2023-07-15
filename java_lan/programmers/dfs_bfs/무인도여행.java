import java.util.*;

class Solution {
    
    int sum;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    
    public void dfs(int[][] arr, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] != 0) {
                visited[nx][ny] = true;
                sum += arr[nx][ny];
                dfs(arr, nx, ny);
            }
        }
    }
    
    public Integer[] solution(String[] maps) {
        Integer[] answer = {};
        int[][] arr = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(!visited[i][j] && arr[i][j] != 0) {
                    sum = arr[i][j];
                    visited[i][j] = true;
                    dfs(arr, i, j);
                    list.add(sum);
                }
            }
        }
        if(list.size() == 0) {
            answer = new Integer[1];
            answer[0] = -1;
        } else {
            Collections.sort(list);
            answer = list.toArray(Integer[]::new);
        }
        
        return answer;
    }
}
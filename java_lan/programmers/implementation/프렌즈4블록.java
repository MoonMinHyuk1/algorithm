import java.util.*;

class Solution {
    
    int answer;
    
    public boolean score(char[][] graph) {
        List<int[]> list = new ArrayList<>();
        int[] dx = {1, 1, 0};
        int[] dy = {0, 1, 1};
        
        for(int i = 0; i < graph.length - 1; i++) {
            for(int j = 0; j < graph[i].length - 1; j++) {
                char c = graph[i][j];
                boolean flag = true;
                if(c == ' ') continue;
                for(int k = 0; k < 3; k++) {
                    if(c != graph[i + dx[k]][j + dy[k]]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for(int[] index: list) {
            if(graph[index[0]][index[1]] != ' ') {
                answer++;
                graph[index[0]][index[1]] = ' ';
            }
            for(int i = 0; i < 3; i++) {
                int nx = index[0] + dx[i], ny = index[1] + dy[i];
                if(graph[nx][ny] != ' ') {
                    answer++;
                    graph[nx][ny] = ' ';
                }
            }
        }
        
        return (list.isEmpty()) ? false : true;
    }
    
    public void down(char[][] graph) {
        for(int j = 0; j < graph[0].length; j++) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < graph.length; i++) {
                if(graph[i][j] != ' ') {
                    stack.push(graph[i][j]);
                    graph[i][j] = ' ';
                }
            }
            int i = graph.length - 1;
            while(!stack.isEmpty()) {
                graph[i--][j] = stack.pop();
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        char[][] graph = new char[m][n];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                graph[i][j] = board[i].charAt(j);
            }
        }
        
        while(score(graph)) {
            down(graph);
        }
        
        return answer;
    }
}
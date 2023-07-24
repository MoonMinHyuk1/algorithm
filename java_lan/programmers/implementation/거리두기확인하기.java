import java.util.*;

class Solution {
    
    public int bfs(Character[][] graph, int x, int y) {
        boolean parX = false, parYP = false, parYM = false;
        
        if(0 <= y + 1 && y + 1 < graph.length) {
            if(graph[x][y + 1] == 'P') return 0;
            if(graph[x][y + 1] == 'X') parYP = true;
        }
        if(0 <= y - 1 && y - 1 < graph.length) {
            if(graph[x][y - 1] == 'P') return 0;
            if(graph[x][y - 1] == 'X') parYM = true;
        }
        if(0 <= x + 1 && x + 1 < graph.length) {
            if(graph[x + 1][y] == 'P') return 0;
            if(graph[x + 1][y] == 'X') parX = true;
        }
        if(0 <= y + 2 && y + 2 < graph.length) {
            if(graph[x][y + 2] == 'P' && !parYP) return 0;
        }
        if(0 <= y - 2 && y - 2 < graph.length) {
            if(graph[x][y - 2] == 'P' && !parYM) return 0;
        }
        if(0 <= x + 2 && x + 2 < graph.length) {
            if(graph[x + 2][y] == 'P' && !parX) return 0;
        }
        if(0 <= y + 1 && y + 1 < graph.length && 0 <= x + 1 && x + 1 < graph.length) {
            if(graph[x + 1][y + 1] == 'P' && (!parX || !parYP)) return 0;
        }
        if(0 <= y - 1 && y - 1 < graph.length && 0 <= x + 1 && x + 1 < graph.length) {
            if(graph[x + 1][y - 1] == 'P' && (!parX || !parYM)) return 0;
        }
        
        return 1;
    }
    
    public int place(String[] places) {
        int result = 1;
        Character[][] graph = new Character[5][5];
        
        for(int i = 0; i < places.length; i++) {
            for(int j = 0; j < places[i].length(); j++) {
                graph[i][j] = places[i].charAt(j);
            }
        }
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 'P') {
                    result = bfs(graph, i, j);
                    if(result == 0) return result;
                }
            }
        }
        
        return result;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            answer[i] = place(places[i]);
        }
        
        return answer;
    }
}
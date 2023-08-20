import java.util.*;

class Solution {
    
    List<int[]> list;
    
    public void dfs(int n, int s, int e, int v) {
        if(n == 1) {
            list.add(new int[]{s, e});
        } else {
            dfs(n - 1, s, v, e);
            list.add(new int[]{s, e});
            dfs(n - 1, v, e, s);
        }
    }
    
    public int[][] solution(int n) {
        int[][] answer = {};
        list = new ArrayList<>();
        
        dfs(n, 1, 3, 2);
        answer = new int[list.size()][2];
        int index = 0;
        for(int[] arr: list) {
            answer[index][0] = arr[0];
            answer[index++][1] = arr[1];
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int find(int[] parent, int index) {
        if(parent[index] == index) {
            return index;
        }
        return find(parent, parent[index]);
    }
    
    public void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        
        if(pa < pb) {
            parent[pb] = pa;
        } else if(pa > pb) {
            parent[pa] = pb;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int i = 0; i < costs.length; i++) {
            if(find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                union(parent, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
}
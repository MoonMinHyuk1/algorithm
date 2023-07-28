class Solution {
    
    int answer;
    int[][] degree = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public void dfs(int[] picks, int[] minerals, int index, int sum) {
        if(index >= minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }
        boolean flag = true;
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] != 0) flag = false;
        }
        if(flag) {
            answer = Math.min(answer, sum);
            return;
        }
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            int tindex = index;
            int tsum = 0;
            for(; tindex < index + 5; tindex++) {
                if(tindex == minerals.length) {
                    break;
                }
                tsum += degree[i][minerals[tindex]];
            }
            picks[i]--;
            dfs(picks, minerals, tindex, sum + tsum);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        int[] arr = new int[minerals.length];
        
        for(int i = 0; i < arr.length; i++) {
            if(minerals[i].equals("diamond")) arr[i] = 0;
            if(minerals[i].equals("iron")) arr[i] = 1;
            if(minerals[i].equals("stone")) arr[i] = 2;
        }
        dfs(picks, arr, 0, 0);
        
        return answer;
    }
}